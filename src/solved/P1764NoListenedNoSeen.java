import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class P1764NoListenedNoSeen{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        // N, M 둘다 순서 상관X, 중복X. 따라서 Set쓰면 될 듯.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);

        LinkedHashSet<String> listens = new LinkedHashSet<>();
        for(int i=0; i<n; i++){
            listens.add(br.readLine());
        }

        HashSet<String> listensSeens = new HashSet<>();
        for(int i=0; i<m; i++){
            line = br.readLine();
            if(listens.contains(line)) listensSeens.add(line); 
        }

        // 메인 로직
        TreeSet<String> results = new TreeSet<>();
        results.addAll(listensSeens);
        
        // 출력 결과
        bw.write(results.size() + "\n");
        for(String result : results) bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}