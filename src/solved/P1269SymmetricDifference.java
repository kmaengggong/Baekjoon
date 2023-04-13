import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;

public class P1269SymmetricDifference{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int aLength = Integer.parseInt(line.split(" ")[0]);
        int bLength = Integer.parseInt(line.split(" ")[1]);

        // 메인 로직
        LinkedHashSet<Integer> as = new LinkedHashSet<>();
        String lines[] = br.readLine().split(" ");
        for(int i=0; i<aLength; i++) as.add(Integer.parseInt(lines[i]));

        String lines2[] = br.readLine().split(" ");
        for(int i=0; i<bLength; i++){
            if(as.contains(Integer.parseInt(lines2[i]))){
                as.remove(Integer.parseInt(lines2[i]));
            }
            else{
                as.add(Integer.parseInt(lines2[i]));
            }
        }

        // 출력 결과
        bw.write(as.size() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}