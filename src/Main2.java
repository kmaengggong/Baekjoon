import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        String line = br.readLine();
        for(int i=0; i<n; i++){
            cards[i] = Integer.parseInt(line.split(" ")[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] checks = new int[m];
        line = br.readLine();
        for(int i=0; i<m; i++){
            checks[i] = Integer.parseInt(line.split(" ")[i]);
        }

        // 메인 로직
        // checks에서 cards가 있는지 확인. 있으면 1, 없으면 0.
        // 아마  O(m * n)
        // 이분탐색
        Arrays.sort(cards);
        Arrays.sort(checks);

        int[] results = new int[m];
        int low;
        int high;
        int mid;

        System.out.println("cards: " + Arrays.toString(cards));
        System.out.println("checks: " + Arrays.toString(checks));

        for(int i=0; i<n; i++){
            low = 0;
            high = m-1;
            mid = (high-low)/2;
            do{
                System.out.println("cards[i]: " + cards[i] + ", low: " + low + ", mid: " + mid + ", high: " + high);
                if(cards[i] == checks[low]){
                    results[low] = 1;
                    break;
                }
                if(cards[i] == checks[high]){
                    results[high] = 1;
                    break;
                }
                if(cards[i] == checks[mid]){
                    results[mid] = 1;
                    break;
                }
                if(cards[i] < checks[mid]){
                    high = mid;
                    mid = (high-low)/2;
                }
                else if(cards[i] > checks[mid]){
                    low = mid;
                    mid = (high-low)/2;
                }
            }while((low != mid) && (high != mid));
        }

        /*
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(checks[i] == cards[j]) results[i] = 1;
            }
        }
        */
        
        // 출력 결과
        for(int result : results){
            bw.write(result + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}