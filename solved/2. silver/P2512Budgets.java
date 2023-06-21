import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2512Budgets{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] budgets = new int[n];

        budgets[0] = Integer.parseInt(st.nextToken());

        for(int i=1; i<n; i++){
            budgets[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        // Logic
        Arrays.sort(budgets);

        int[] sums = new int[n];
        sums[0] = budgets[0];

        for(int i=1; i<n; i++){
            sums[i] = sums[i-1] + budgets[i];
        }
        
        if(sums[n-1] <= m){
            sb.append(budgets[n-1]);
        }
        else{
            int startVal = 0;
            int endVal = budgets[n-1];
            int midVal = (startVal+endVal)/2;
            int sum = 0;

            while(startVal != midVal && endVal != midVal){
                sum = 0;
                int breakIdx = 0;

                for(int i=0; i<n; i++){
                    if(budgets[i] > midVal){
                        breakIdx = i-1;
                        break;
                    }
                }

                sum += midVal * (n-breakIdx-1);

                if(breakIdx >= 0) sum += sums[breakIdx];
                
                if(sum > m){
                    endVal = midVal;
                }
                else if(sum < m){
                    startVal = midVal;
                }
                else break;

                midVal = (startVal+endVal)/2;
            }

            sb.append(midVal);
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}