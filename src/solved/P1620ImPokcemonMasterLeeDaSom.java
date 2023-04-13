import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class P1620ImPokcemonMasterLeeDaSom{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        
        // 메인 로직
        // 포켓몬 도감이 먼저들어오는 이상, 일단 도감을 저장해야 됨
        // N과 M 모두 순서O(Set 안됨), 중복X.
        // 번호와 포켓몬 이름이 있으니깐 key, value 쓰면 될듯
        HashMap<Integer, String> pocketDict = new HashMap<>();
        // 그냥 value, key가 거꾸로 된 해쉬 맵도 만드는 방법
        // 이 entrySet()으로 구하는 것보다 훨씬 빠름.
        HashMap<String, Integer> reversePocketDict = new HashMap<>();
        for(int i=1; i<=n; i++){
            line = br.readLine();
            pocketDict.put(i, line);
            reversePocketDict.put(line, i);
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            // 입력값이 정수인지 스트링인지 판단 -> try, catch 사용
            line = br.readLine();
            try{
                idx = Integer.parseInt(line);
                sb.append(pocketDict.get(idx)).append("\n");
            } catch(Exception e){
                sb.append(reversePocketDict.get(line)).append("\n");
            }
        }

        // 출력 결과
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}