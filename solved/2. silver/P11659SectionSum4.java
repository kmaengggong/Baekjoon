import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P11659SectionSum4{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);  // 수의 개수
        int m = Integer.parseInt(lines[1]);  // 합을 구해야 하는 횟수
        
        int[] nums = new int[n];
        lines = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(lines[i]);
        }

        // Logic
        int[] sums = new int[n];
        sums[0] = nums[0];
        for(int i=1; i<n; i++){
            sums[i] = sums[i-1] + nums[i];
        }

        int i, j;
        for(int x=0; x<m; x++){
            lines = br.readLine().split(" ");
            i = Integer.parseInt(lines[0]);
            j = Integer.parseInt(lines[1]);

            if(i == 1) sb.append(sums[j-1]).append("\n");
            else sb.append(sums[j-1]-sums[i-2]).append("\n");     
        }        

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}