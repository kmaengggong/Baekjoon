import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> numbers = new HashMap<>();
        int number;
        for(int i=0; i<n; i++){
            number = Integer.parseInt(st.nextToken());
            if(numbers.containsKey(number)){
                numbers.put(number, numbers.get(number)+1);
            }
            else{
                numbers.put(number, 1);
            }
        }

        // Logic
        ArrayList<Integer> arrNumbers = new ArrayList<>();
        arrNumbers.addAll(numbers.keySet());
        Collections.sort(arrNumbers);
        System.out.println(arrNumbers.toString());

        HashSet<Integer> goods = new HashSet<>();
        int len = arrNumbers.size();
        for(int num : arrNumbers){
            int startIndex = 0;
            int endIndex = len-1;
            System.out.print("num: " + num + ", ");
            System.out.println("start: " + startIndex + ", end: " + endIndex);
            int sum;

            while(startIndex < endIndex){
                sum = arrNumbers.get(startIndex) + arrNumbers.get(endIndex);
                System.out.print(sum + " ");
                if(sum < num){
                    startIndex += 1;
                }
                else if(sum > num){
                    endIndex -= 1;
                }
                else{
                    goods.add(num);
                    break;
                }
            }
            System.out.println();
        }

        int count = 0;
        for(int good : goods){
            if(numbers.containsKey(good)){
                count += numbers.get(good);
            }
        }
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}