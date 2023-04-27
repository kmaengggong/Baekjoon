import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class P9020GoldbachsConjecture{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] evens = new int[n];
        int even;
        int max = 0;  // 에라토스테네스의 체 최댓값
        for(int i=0; i<n; i++){
            even = Integer.parseInt(br.readLine());
            evens[i] = even;
            if(even > max) max = even;
        }

        // Logic
        // 1. 에라토스테네스의 체로 소수를 구함
        LinkedHashSet<Integer> decimals = new LinkedHashSet<>();
        for(int i=2; i<=max; i++){
            decimals.add(i);
        }

        for(int i=2; i<max; i++){
            for(int j=i+i; j<=max; j+=i){
                decimals.remove(j);
            }
        }

        // 2. 소수를 가지고 브루트포스로 더해서 나오는지 확인
        // 소수 집합 역순과 순서대로 된 소수 집합 비교
        ArrayList<Integer> tempDecimals = new ArrayList<>();
        tempDecimals.addAll(decimals);
        Collections.reverse(tempDecimals);

        for(int i=0; i<n; i++){
            even = evens[i];

            int half = even/2;

            int a = 0;
            int b = 0;

            // 절반부터 구하는 이유는 두 소수의 차가 가장 작은 것부터 구하기 위함
            for(int tempDecimal : tempDecimals){
                if(tempDecimal > half) continue;
                if(decimals.contains(even-tempDecimal)){
                    a = tempDecimal;
                    b = even-tempDecimal;
                    break;
                }
            }

            sb.append(a).append(" ").append(b).append("\n");
        }

        // Print
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}