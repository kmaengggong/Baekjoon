import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1924Year2007{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] lines = br.readLine().split(" ");
        int x = Integer.parseInt(lines[0]);
        int y = Integer.parseInt(lines[1]);

        // Logic
        // 1 1 -> 1, 1 31 -> 31
        // 2 1 -> 32, 2 28 -> 59
        int[] dates = {
            31, 28, 31, 30, 31,
            30, 31, 31, 30, 31,
            30, 31  
        };
        String[] days = {
            "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"
        };

        while(x > 1){
            y += dates[x-2];
            x -= 1;
        }
        
        int day = y%7 - 1;
        if(day == -1) day = 6;
        sb.append(days[day]);

        // Print
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}