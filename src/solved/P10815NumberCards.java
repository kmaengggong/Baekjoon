import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class P10815NumberCards{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> iCards = new HashSet<>();
        //HashSet<Integer> fCards = new HashSet<>();
        // 내 카드: 순서 상관x, 중복 x
        // 찾을 카드: 순서 상관o, 중복 x
        //ArrayList<Integer> iCards = new ArrayList<>();
        ArrayList<Integer> fCards = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        String[] lineN = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            iCards.add(Integer.parseInt(lineN[i]));
        }

        int m = Integer.parseInt(br.readLine());
        String[] lineM = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            fCards.add(Integer.parseInt(lineM[i]));
        }

        // 메인 로직
        // 1. 적절한 집합 설정
        // 2. BufferedReader, BufferedWriter
        // 3. StringBuilder
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<m; i++){
            if(iCards.contains(fCards.get(i))){
                sb.append(1).append(" ");
            }
            else{
                sb.append(0).append(" ");
            }
        }

        // 출력 결과
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}