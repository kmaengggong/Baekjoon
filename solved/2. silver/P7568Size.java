import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P7568Size{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] wHs = new int[n][2];
        String[] lines;
        for(int i=0; i<n; i++){
            lines = br.readLine().split(" ");
            wHs[i][0] = Integer.parseInt(lines[0]);
            wHs[i][1] = Integer.parseInt(lines[1]);
        }

        // 로직
        int count;
        // 하나씩 검사
        for(int i=0; i<n; i++){
            count = 1;
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(wHs[i][0] < wHs[j][0] && wHs[i][1] < wHs[j][1]) count += 1;
            }
            sb.append(count).append(" ");
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}