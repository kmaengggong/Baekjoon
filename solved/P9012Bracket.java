import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

 public class P9012Bracket{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        // 로직
        StringBuilder sb = new StringBuilder();
        int count = 0;
        outer: for(int i=0; i<n; i++){
            String line = br.readLine();
            char[] lines = line.toCharArray();
            int length = lines.length;
            
            if(lines[0] == ')'){
                sb.append("NO").append("\n");
                continue;
            }
            if(lines[length-1] == '('){
                sb.append("NO").append("\n");
                continue;
            }

            count += 1;

            for(int j=1; j<length; j++){
                if(count <= -1){
                    sb.append("NO").append("\n");
                    count = 0;
                    continue outer;
                }
                if(lines[j] == ')') count -= 1;
                else count += 1;
            }
            if(count == 0) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

            count = 0;
        }
 
        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
 }