import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Asdf{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int t = Integer.parseInt(line);
        int ab[][] = new int[t][2];
        for(int i=0; i<t; i++){
            line = br.readLine();
            ab[i][0] = Integer.parseInt(line.split(" ")[0]);
            ab[i][1] = Integer.parseInt(line.split(" ")[1]);
        }

        // 메인 로직
        // 예를 들어 6, 15의 최소공배수일 때,
        // 6 = 1 * 2 * 3, 15 = 1 * 3 * 5,
        // 서로 없는 값을 곱하면 6 * 5 = 30, 15 * 2 = 30
        // 최소공배수가 된다.
        int results[] = new int[t];
        ArrayList<Integer> as = new ArrayList<>();
        for(int i=0; i<t; i++){
            // 1이면 반대 수가 그냥 최소공배수
            if(ab[i][0] == 1){
                results[i] = ab[i][1];
                continue;
            }
            if(ab[i][1] == 1){
                results[i] = ab[i][0];
                continue;
            }

            // a 소인수분해
            int temp = ab[i][0];
            int x = 2;
            while(temp != 1 && x <= ab[i][0]/2){
                if(temp%x == 0){
                    temp /= x;
                    as.add(x);
                }
                else{
                    x += 1;
                }
            }
            if(as.size() == 0) as.add(ab[i][0]);

            // b 소인수분해
            temp = ab[i][1];
            x = 2;
            while(temp != 1 && x <= ab[i][1]/2){
                if(temp%x == 0){
                    temp /= x;
                    if(as.contains(x)){
                        as.remove(as.indexOf(x));
                    }
                }
                else{
                    x += 1;
                }
            }
            if(as.contains(temp)) as.remove(as.indexOf(temp));

            // b에는 없는 a의 소인수 * b
            results[i] = ab[i][1];
            for(int a : as){
                results[i] *= a;
            }

            as.clear();
        }
        
        // 출력 결과
        for(int result : results){
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}