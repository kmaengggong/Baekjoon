import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1234567891을 나누라고 문제에 써있으면 좀 덧나냐
public class P15829Hashing{
    static StringBuffer sb;
    
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        char[] target = br.readLine().toCharArray();

        // Logic
        int div = 1234567891;
        int len = target.length;
        long result = 0;

        for(int i=0; i<len; i++){
            long add = 1;
            for(int j=0; j<i; j++){
                add = add*31%div;
            }

            result = (result+add*(target[i]-96)%div)%div;
        }

        sb.append(result);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}