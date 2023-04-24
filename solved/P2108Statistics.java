package solved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class P2108Statistics{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());  // 홀수
        int[] numbers = new int[n];
        HashMap<Integer, Integer> counts = new HashMap<>();

        int avg = 0;  // 평균값
        int mid = 0;  // 중앙값
        int most = 0;  // 최빈값
        int max = Integer.MIN_VALUE;  // 최대값
        int min = Integer.MAX_VALUE;  // 최솟값
        int gap = 0;

        int number;
        for(int i=0; i<n; i++){
            number = Integer.parseInt(br.readLine());
            numbers[i] = number;
            
            avg += number;
            // 아직 없는 상태
            if(!counts.containsKey(number)){
                counts.put(number, 1);
            }
            else{
                int count = counts.get(number);
                counts.put(number, count+1);
            }
        }

        // 로직
        double div = (double)avg/n;
        avg = (int)Math.round(div);

        Arrays.sort(numbers);
        int length = numbers.length;
        mid = numbers[length/2];

        ArrayList<Integer> inHand = new ArrayList<>();
        TreeMap<Integer, Integer> orderedCounts = new TreeMap<>();
        orderedCounts.putAll(counts);
        Iterator<Integer> itr = orderedCounts.keySet().iterator();

        int mostCount = 0;
        int count = 0;
        
        // 같은 것이 있을 때는 두 번째로 작은 값으로 구해야됨
        while(itr.hasNext()){
            number = itr.next();
            count = counts.get(number);
            if(count > mostCount){
                mostCount = count;
                most = number;
                inHand.clear();
                inHand.add(number);
            }
            else if(count == mostCount && inHand.size() == 1){
                inHand.add(number);
            }
        }
        if(inHand.size() == 1){
            most = inHand.get(0);
        }
        else{
            most =inHand.get(1);
        }

        max = numbers[length-1];
        min = numbers[0];
        gap = max - min;

        sb.append(avg).append("\n").append(mid).append("\n").append(most).append("\n").append(gap);

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}