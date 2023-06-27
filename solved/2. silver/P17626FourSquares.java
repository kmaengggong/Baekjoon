import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P17626FourSquares{
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
            int sqrt = (int)Math.sqrt(i);
            int min = Integer.MAX_VALUE;

            for(int j=sqrt; j>0; j--){
                int now = i;
                int count = 0;

                while(now > 0){
                    if(dp[now] > 0){
                        count += dp[now];
                        break;
                    }
                    if(now - j*j >= 0){
                        count += 1;
                        now -= j*j;
                    }
                    else{
                        j -= 1;
                    }
                }
                min = Math.min(min, count);
                if(min == 1) break;
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