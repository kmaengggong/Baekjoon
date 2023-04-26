import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class P18870CoordinateCompression{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        String[] lines = br.readLine().split(" ");
        
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(lines[i]);
            numbers.add(number);
        }   

        // 로직
        // 1. numbers를 정렬
        TreeSet<Integer> orders = new TreeSet<>();
        orders.addAll(numbers);

        // 2. 정렬된 순서로 HashMap에 해당하는 숫자 부여
        HashMap<Integer, Integer> checksheet = new HashMap<>();
        int idx = 0;
        for(int order : orders){
            checksheet.put(order, idx++);
        }

        // 3. numbers에서 checksheet에 해당하는 값 출력
        StringBuilder sb = new StringBuilder();
        for(int number : numbers){
            sb.append(checksheet.get(number)).append(" ");
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}