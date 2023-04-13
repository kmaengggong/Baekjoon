import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class P7785PeopleInCompany{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 메인 로직
        // 그냥 Set에 들어올 때 저장하고 나갈 때 지우는 게 빠를듯
        HashSet<String> workers = new HashSet<>();
        String[] line;
        for(int i=0; i<n; i++){
            line = br.readLine().split(" ");
            if(line[1].equals("enter")){
                workers.add(line[0]);
            }
            else{
                workers.remove(line[0]);
            }
        }

        // 정렬도 해야됨
        // HashMap -> ArrayList 후 정렬
        StringBuilder sb = new StringBuilder();
        ArrayList<String> sortedWorkers = new ArrayList<>(workers);
        Collections.sort(sortedWorkers);
        Collections.reverse(sortedWorkers);
        for(String worker : sortedWorkers) sb.append(worker).append("\n"); 

        // 출력 결과
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}