import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P5525IOIOI{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        char[] input = br.readLine().toCharArray();
        
        // Logic
        int[] result = new int[m+1];
        int count = 0;
        int len = m-2;

        int i = 0;
        while(i < len){
            if(input[i] == 'I' && input[i+1] == 'O' && input[i+2] == 'I'){
                count += 1;
                i += 2;
            }
            else{
                if(count != 0){
                    result[count] += 1;
                    count = 0;
                }
                i += 1;
            }
        }
        result[count] += 1;
        int answer = 0;
        
        for(int j=n; j<=m; j++){
            if(result[j] > 0){
                answer += (j-n+1) * result[j];
            }
        }

        sb.append(answer);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}