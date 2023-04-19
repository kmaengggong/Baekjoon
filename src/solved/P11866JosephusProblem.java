import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P11866JosephusProblem{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);
        
        // 로직
        // Map으로 하는 거 -> 한 바퀴 돌고 그 다음이 어려움
        // List로 하는 거 -> 삭제할 때 시간이 오래 걸릴듯
        sb.append("<");

        int[] josephus = new int[n+1];
        for(int i=1; i<=n; i++){
            josephus[i] = i;
        }
        
        int count = 0;
        int current = 1;
        int delete;
        while(count < n){
            delete = k;
            while(true){
                if(josephus[current] == 0){
                    if(current >= n) current = 1;
                    else current += 1;
                    continue;
                }
                delete -= 1;
                if(delete == 0) break;
                if(current >= n) current = 1;
                else current += 1;
            }
            sb.append(josephus[current]).append(", ");
            josephus[current] = 0;
            count += 1;
        }

        sb.delete(sb.length()-2, sb.length());
        sb.append(">");

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}