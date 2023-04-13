import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        // 중복 가능. 순서 상관x
        ArrayList<Integer> cards = new ArrayList<>();
        String[] line2 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            cards.add(Integer.parseInt(line2[i]));
        }

        // 메인 로직
        int max = 0;
        outer: for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    int sum = cards.get(i) + cards.get(j) + cards.get(k);
                    if(sum == m){
                        max = m;
                        break outer;
                    }
                    if(sum > m) continue;
                    if(sum > max) max = sum;
                }
            }
        }

        // 출력 결과
        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}