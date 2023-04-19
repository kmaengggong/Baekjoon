import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

 public class P27960ShootingBet{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String lines[] = br.readLine().split(" ");
        short a = Short.parseShort(lines[0]);
        short b = Short.parseShort(lines[1]);
        
        // 로직
        // 10 0000 0011 / 01 0000 0011 -> 11 0000 0000
        short c = (short)(a^b);
    
        // 출력
        bw.write(c + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
 }