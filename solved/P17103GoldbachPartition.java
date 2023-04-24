import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class P17103GoldbachPartition{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] numbers = new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(br.readLine());
            numbers[i] = number;
            if(number > max) max = number;
        }

        // 로직
        // 1. 갓라토스테네스의 체: 순서 보장되는 LinkedHashSet
        LinkedHashSet<Integer> decimals = new LinkedHashSet<>();
        final int limit = max;
        
        for(int i=2; i<=limit; i++){
            decimals.add(i);
        }
        for(int i=2; i*i<=limit; i++){
            for(int j=2; j*i<=limit; j++){
                decimals.remove(j*i);
            }
        }

        // 2. LinkedHashSet 역순과 비교
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int number;
    
        for(int i=0; i<n; i++){
            number = numbers[i];
            if(decimals.contains(number/2)) count += 1;

            ArrayList<Integer> tempDecimals = new ArrayList<>();
            tempDecimals.addAll(decimals);
            Collections.reverse(tempDecimals);
            
            for(int tempDecimal : tempDecimals){
                if(tempDecimal*2 <= number) break;
                if(decimals.contains(number-tempDecimal)) count += 1;
            }
            sb.append(count).append("\n");
            count = 0;
        }
        
        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}