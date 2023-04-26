import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1712BreakevenPoint{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] lines = br.readLine().split(" ");
        int a = Integer.parseInt(lines[0]);
        int b = Integer.parseInt(lines[1]);
        int c = Integer.parseInt(lines[2]);

        // Logic
        if(b >= c) sb.append(-1);
        else{
            // 직접 구하기
            /*long n = 1;
            while(a + b*n >= n*c){
                n += 1;
            }*/

            // 수식으로 구하기
            long n = a/(c-b)+1;
            sb.append(n);
        }

        // Print
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}