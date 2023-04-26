import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P4153RightTriangle{
    static StringBuilder sb = new StringBuilder();
    public static void isRightTriangle(int a, int b, int large){
        if(large*large == a*a + b*b) sb.append("right").append("\n");
        else sb.append("wrong").append("\n");
    }

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] lines = br.readLine().split(" ");
        
        // 로직
        while(true){
            int a = Integer.parseInt(lines[0]);
            int b = Integer.parseInt(lines[1]);
            int c = Integer.parseInt(lines[2]);
            if(a == 0 && b == 0 && c == 0) break;

            if(a >= b && a >= c) isRightTriangle(b, c, a);
            else if(b >= a && b >= c) isRightTriangle(a, c, b);
            else if(c >= a && c >= b) isRightTriangle(a, b, c);

            lines = br.readLine().split(" ");    
        }
        
        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}