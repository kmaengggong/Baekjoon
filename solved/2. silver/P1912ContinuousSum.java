import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1912ContinuousSum{
    static StringBuffer sb;
    
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];

        for(int i=0; i<n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        // Logic
        int[] dp = new int[n];
        dp[0] = numbers[0];
        int max = dp[0];

        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i-1]+numbers[i], numbers[i]);
            if(dp[i] > max) max = dp[i];
        }

        sb.append(max);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}