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

public class P1253Good{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> numbers = new HashMap<>();
        ArrayList<Integer> arrNumbers = new ArrayList<>();
        int number;
        for(int i=0; i<n; i++){
            number = Integer.parseInt(st.nextToken());
            if(numbers.containsKey(number)){
                numbers.put(number, numbers.get(number)+1);
            }
            else{
                numbers.put(number, 1);
            }
            arrNumbers.add(number);
        }

        // Logic
        int len = arrNumbers.size();
        Collections.sort(arrNumbers);

        if(len < 3){
            sb.append(0);
        }
        else{
            HashSet<Integer> goods = new HashSet<>();
        
            int start, end;
            for(int i=0; i<len; i++){
                int num = arrNumbers.get(i);
                int startIndex = 0;
                int endIndex = len-1;
                int sum;

                while(startIndex < endIndex){
                    start = arrNumbers.get(startIndex);
                    end = arrNumbers.get(endIndex);
                    sum = start+end;
                    
                    if(startIndex == i)startIndex += 1;
                    else if(endIndex == i) endIndex -= 1;
                    else if(sum < num){
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
            }

            int count = 0;
            for(int good : goods){
                if(numbers.containsKey(good)){
                    count += numbers.get(good);
                }
            }
            sb.append(count);
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

/* 정답코드: 336ms -> 192ms
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // Logic
        Arrays.sort(numbers);
        
        int result = 0;
        for(int i=0; i<n; i++){
            int num = numbers[i];
            int startIndex = 0;
            int endIndex = n-1;

            int start, end, sum;
            while(startIndex < endIndex){
                start = numbers[startIndex];
                end = numbers[endIndex];
                sum = start + end;
                if(sum == num){
                    if(startIndex != i && endIndex != i){
                        result += 1;
                        break;
                    }
                    else if(startIndex == i){
                        startIndex += 1;
                    }
                    else if(endIndex == i){
                        endIndex -= 1;
                    }
                }
                else if(sum < num){
                    startIndex += 1;
                }
                else{
                    endIndex -= 1;
                }
            }
        }
        sb.append(result);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */