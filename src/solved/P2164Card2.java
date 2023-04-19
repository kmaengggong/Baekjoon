import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2164Card2{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        // 로직
        // 1, 2, 24, 2468, 246810121416, ... 패턴
        if(n == 1) sb.append(1);  
        else{
            int top = 2;
            int now = 0;
            for(int i=1; i<n; i++){
                if(now == top){
                    top <<= 1;
                    now = 2;
                }
                else{
                    now += 2;
                }
            }
            sb.append(now);
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}