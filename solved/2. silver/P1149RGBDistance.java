import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1149RGBDistance{
    static StringBuffer sb;
    
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        
        int[][] rgbs = new int[n][3];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++){
                rgbs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Logic
        int[][] dp = new int[n][3];
        dp[0][0] = rgbs[0][0];
        dp[0][1] = rgbs[0][1];
        dp[0][2] = rgbs[0][2];
        
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgbs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgbs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgbs[i][2];
        }

        sb.append(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}