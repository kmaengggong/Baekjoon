import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp{
    public static void getBestSum(int n, int m, int j){
        if(j == n-4){
            
        }
        else{
            for(int i=j; i<n; i++){
                getBestSum(n, m, i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        
        // 입력 저장
        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        
        //int cards[] = new int[n];
        int cards[] = new int[n];
        line = br.readLine();
        for(int i=0; i<n; i++){
            cards[i] = Integer.parseInt(line.split(" ")[i]);
        }

        // 메인 로직
        int sumN = 0;
        for(int i=0; i<n; i++) sumN += cards[i];  // 먼저 모든 카드의 합을 구하고,

        // 카드 - (장의 합
        int sum = 0;
        int bestSum = 0;
        int result = 0;
        System.out.println("m: " + m);
        // i, j 번째 카드 2장을 뺀 값
        outer: for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                sum = sumN - cards[i] - cards[j];
                System.out.println("sum: " + sum);
                System.out.println("bsetSSum: " + bestSum);
                // 7장 합이 m과 같으면 최댓값 그대로 종료
                if(sum == m){
                    System.out.println("wtf");
                    result = sum;
                    break outer;
                }
                // 7장 합이 m 초과면 취급 안함
                if(sum > m) continue;
                // m에 더 근접한 경우를 저장 
                if((m - sum) < (m - bestSum)){
                    bestSum = sum;
                    result = bestSum;
                }
            }
        }
 
        // 출력
        System.out.println(result);

        br.close();
    }
}