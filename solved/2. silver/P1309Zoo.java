import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1309Zoo{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        // Logic
        // 1[3 - 1마리. 1/2]
        // 00
        // 10 / 01
        // 2[7 - 2마리. 1/4/2]
        // 00 00
        // 00 01 / 00 10 / 01 00 / 10 00
        // 10 01 / 01 10
        // 3[17 - 3마리. 1/6/8/2]
        // 00 00 00
        // 00 00 01 / 00 00 10 / 00 01 00 / 00 10 00 / 01 00 00 / 10 00 00
        // 00 01 10 / 00 10 01 / 01 00 01 / 01 00 10 / 10 00 01 / 10 00 10 / 01 10 00 / 10 01 00
        // 10 01 10 / 01 10 01
        // 4[41 - 4마리. 1/?/?/?/2]

        final int DIV = 9901;
        long[] dp = new long[n+1];
        dp[1] = 3;
        if(n > 1) dp[2] = 7;

        for(int i=3; i<=n; i++){
            dp[i] = ((dp[i-2]%DIV) + (dp[i-1]*2)%DIV)%DIV;
        }
        
        sb.append(dp[n]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}