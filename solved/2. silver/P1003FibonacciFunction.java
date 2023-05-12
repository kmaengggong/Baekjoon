import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1003FibonacciFunction{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        // Logic
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                sb.append("1 0").append("\n");
                continue;
            }
            int[] zero = new int[n+1];
            int[] one = new int[n+1];
            int[] fibo = new int[n+1];
            fibo[0] = 0;
            fibo[1] = 1;
            zero[0] = 1;
            zero[1] = 0;
            one[0] = 0;
            one[1] = 1;

            for(int j=2; j<=n; j++){
                fibo[j] = fibo[j-1] + fibo[j-2];
                zero[j] = zero[j-1] + zero[j-2];
                one[j] = one[j-1] + one[j-2];
            }
            sb.append(zero[n]).append(" ").append(one[n]).append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}