import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2869SnailWannaClimb{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lines = br.readLine().split(" ");
        int a = Integer.parseInt(lines[0]);  // 낮에 올라가는 길이
        int b = Integer.parseInt(lines[1]);  // 밤에 떨어지는 길이
        int v = Integer.parseInt(lines[2]);  // 올라갈 높이
        
        // 로직
        int ab = a-b;  // 하루 끝날때 올라갈 수 있는 높이
        int day = v/ab;
        if(v%ab != 0) day += 1;
        
        int abV = ab*day;
        int aV = abV+b;
        while(aV-ab >= v){
            day -= 1;
            aV -= ab;
        }

        // 출력
        bw.write(day + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}