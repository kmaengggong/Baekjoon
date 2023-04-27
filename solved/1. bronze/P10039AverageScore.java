import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10039AverageScore{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        // Logic
        final int n = 5;
        int sum = 0;
        int score;

        for(int i=0; i<n; i++){
            score = Integer.parseInt(br.readLine());
            if(score < 40) score = 40;    
            sum += score;
        }
        sb.append(sum/n);

        // Print
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}