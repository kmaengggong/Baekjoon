import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470TwoLiquids{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();
    
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] liquids = new int[n];

        for(int i=0; i<n; i++) liquids[i] = Integer.parseInt(st.nextToken());

        // Logic
        Arrays.sort(liquids);
        int start = 0;
        int end = n-1;
        int minStart = 0;
        int minEnd = n-1;
        int min = Integer.MAX_VALUE;
        int now = 0;

        while(start < end){
            now = Math.abs(liquids[start]+liquids[end]);
            if(now < min){
                min = now;
                minStart = start;
                minEnd = end;
            }
            if(start+1 > end) break;

            int startUp = Math.abs(liquids[start+1] + liquids[end]);
            int endUp = Math.abs(liquids[start] + liquids[end-1]);

            if(startUp > endUp){
                end -= 1;
            }
            else{
                start += 1;
            }
        }

        sb.append(liquids[minStart]).append(" ").append(liquids[minEnd]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}