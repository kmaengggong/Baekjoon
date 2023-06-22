import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1699SquareNumberSum{
    static StringBuffer sb;
    
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        // Logic
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            int start = (int)Math.sqrt(i);
            int min = n;

            for(int j=1; j<=start; j++){
                    int count = 0;
                int target = i;
                int now = j;
                outer:while(target > 0){
                    int num = (int)Math.pow(now, 2);
                    while(target-num >= 0){
                        target -= num;
                        count += 1;
                        if(dp[target] > 0){
                            count += dp[target];
                            break outer;
                        }
                    }
                    now -= 1;
                }
                min = Math.min(count, min);
            }

            dp[i] = min;
        }

        sb.append(dp[n]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}