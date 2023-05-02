import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2847GameDongjoonMade{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] levels = new int[n];
        for(int i=0; i<n; i++){
            levels[i] = Integer.parseInt(br.readLine());
        }

        // Logic
        int last = n-1;
        int count = 0;
        while(last > 0){
            int lastNumber = levels[last];
            int nextNumber = levels[last-1];
            if(nextNumber >= lastNumber){
                int gap = nextNumber-lastNumber+1;
                levels[last-1] = lastNumber-1;
                count += gap;
            }
            last -= 1;
        }
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}