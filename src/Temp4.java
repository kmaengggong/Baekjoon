import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{
    public static int getNextMin(ArrayList<Integer> numbers){
        int min = numbers.get(0);
        for(int number : numbers) if(number < min) min = number;
        return min;
    }
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 로직
        String[] lines = br.readLine().split(" ");
        int number = Integer.parseInt(lines[0]);
        int min = number;
        int idx = 0;

        ArrayList<Integer> numbers = new ArrayList<>();
        int[][] results = new int[n][1];
        numbers.add(idx, number);
        results[0][0] = number;

        for(int i=1; i<n; i++){
            number = Integer.parseInt(lines[i]);
            if(number < min) min = number;
            numbers.add(i, number);
            results[i][0] = 0;
            idx += 1;
        }

        for(int i=0; i<n; i++){
            numbers.remove(Integer.valueOf(min));
            for(int j=0; j<numbers.size(); j++) System.out.print(numbers.get(j) + " ");
            System.out.println();
            min = getNextMin(numbers);
            results[]
            results.replace(min, idx);
            for(int result : results.keySet()) System.out.print(result + " ");
            System.out.println();
            idx += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int result : results.keySet()){
            sb.append(result).append(" ");
        }

        /*StringBuilder sb = new StringBuilder();
        String[] lines = br.readLine().split(" ");
        HashMap<Integer, Integer> results = new HashMap<>();

        int num = Integer.parseInt(lines[0]);
        int min = num;
        int idx = 1;

        results.put(num, 0);
        for(int i=1; i<n; i++){
            
            num = Integer.parseInt(lines[i]);
            if(num < min){
                min = num;
                results.put(num, 0);
                idx += 1;
            }
            else{
                results.replace(num, idx);
                idx += 1;
            }
        }

        for(int result : results.keySet()){
            sb.append(result).append(" ");
        }
        /*int[] numbers = new int[n];
        int[] results = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(lines[i]);
        }

        int min;
        for(int i=0; i<n; i++){
            if(i == 0) min = numbers[i];
            else{
                if(numbers[i] < min) min = numbers[i];
            }
        }
        int idx = 0;
        for(int i=0; i<n; i++){
            if(numbers[i] == min) results
        }
        */

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}