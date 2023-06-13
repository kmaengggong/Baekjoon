import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P9184FunnyFunctionExcution{
    static StringBuffer sb;
    static int[][][] dp;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        dp = new int[101][101][101];
        for(int i=0; i<=50; i++){
            for(int j=0; j<101; j++){
                for(int k=0; k<101; k++){
                    dp[i][j][k] = 1;
                    dp[j][i][k] = 1;
                    dp[j][k][i] = 1;
                }
            }
        }

        while(!(a == -1 && b == -1 && c == -1)){
            int result = 0;

            result = w(a+50, b+50, c+50);

            sb.append("w(")
                .append(a).append(", ")
                .append(b).append(", ")
                .append(c).append(") = ")
                .append(result).append("\n");

            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static int w(int a, int b, int c){
        if(dp[a][b][c] != 0) return dp[a][b][c];

        if(a <= 50 || b <= 50 || c <= 50) return 1;

        if(a > 70 || b > 70 || c > 70){
            if(dp[a][b][c] == 0) dp[a][b][c] = w(70, 70, 70);

            return dp[a][b][c];
        }

        if(a < b && b < c){
            if(dp[a][b][c-1] == 0) dp[a][b][c-1] = w(a, b, c-1);
            if(dp[a][b-1][c-1] == 0) dp[a][b-1][c-1] = w(a, b-1, c-1);
            if(dp[a][b-1][c] == 0) dp[a][b-1][c]= w(a, b-1, c);

            return dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
        }
        
        if(dp[a-1][b][c] == 0) dp[a-1][b][c] = w(a-1, b, c);
        if(dp[a-1][b-1][c] == 0) dp[a-1][b-1][c] = w(a-1, b-1, c);
        if(dp[a-1][b][c-1] == 0) dp[a-1][b][c-1] = w(a-1, b, c-1);
        if(dp[a-1][b-1][c-1] == 0) dp[a-1][b-1][c-1] = w(a-1, b-1, c-1);

        return dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
    }
}