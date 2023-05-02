import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1748NumberKeepWriting1{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // Logic
        int result = 0;
        while(n > 0){
            int digit = 1;
            int num = n;
            while(num/10 > 0){
                num /= 10;
                digit += 1;
            }
            
            int dex = (int)Math.pow(10, digit-1)-1;
            int left = n-dex;
            result += left*digit;
            n = dex;
        }

        sb.append(result);
        
        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}