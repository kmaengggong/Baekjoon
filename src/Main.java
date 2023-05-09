import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        // Logic
        int[] results = new int[n+1];
        for(int i=1; i<=n; i++){
            char[] now = Integer.toBinaryString(i).toCharArray();
            int len = now.length;
            int up = 1;
            int oneCount = 0;
            for(int j=0; j<len; j++){
                if(j == 0 && now[j] == 0){
                    up = 0;
                    break;
                }
                if(now[j] == '1') oneCount += 1;
                else oneCount = 0;
                if(oneCount > 1){
                    up = 0;
                    break;
                }
            }
            results[i] = results[i-1] + up;
        }

        sb.append(results[n]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}