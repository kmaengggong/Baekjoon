import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class P117272xNTiling2{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // Logic
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
        }
        
        sb.append(dp[n]);
        
        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}