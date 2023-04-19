import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

 public class P1920FindingNumber{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> numbers = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        String[] lines = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            numbers.add(Integer.parseInt(lines[i]));    
        }
        
        // 로직
        // 중복이 있는 건지 없는 건지 문제에 안써져잇잖슴
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        String[] lines2 = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            if(numbers.contains(Integer.parseInt(lines2[i])))
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
 }