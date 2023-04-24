import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P24313AsymptoticNotation{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lines = br.readLine().split(" ");
        int a1 = Integer.parseInt(lines[0]);
        int a0 = Integer.parseInt(lines[1]);
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        
        // 로직
        int result;
        if(a1 > c) result = 0;
        else{
            if((a1*n0 + a0) > (c*n0)) result = 0;
            else result = 1;
        }
        // 출력
        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}