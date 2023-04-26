import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P11399ATM{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 로직
        String[] lines = br.readLine().split(" ");
        int[] times = new int[n];
        int total = 0;
        
        for(int i=0; i<n; i++){
            times[i] = Integer.parseInt(lines[i]);
        }

        Arrays.sort(times);
        
        int prevTotal = times[0];
        total += times[0];
        int currentTime = 0;
        for(int i=1; i<n; i++){
            currentTime = prevTotal + times[i];
            total += currentTime;
            prevTotal = currentTime;
        }
        sb.append(total);

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}