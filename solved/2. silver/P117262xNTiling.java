import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P117262xNTiling{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // Logic
        int[] dp = new int[n+2];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        sb.append(dp[n]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}