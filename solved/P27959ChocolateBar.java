import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

 public class P27959ChocolateBar{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int m = Integer.parseInt(lines[1]);
        
        // 로직
        int money = n*100;
        String result;
        if(money >= m) result = "Yes";
        else result = "No";

        // 출력
        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }
 }