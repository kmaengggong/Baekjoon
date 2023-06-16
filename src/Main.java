import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static StringBuffer sb;
    static int n, s;
    static int[] numbers;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) numbers[i] = Integer.parseInt(st.nextToken()); 
        
        s = Integer.parseInt(br.readLine());

        // Logic
        int start = 0;
        int realStart = 0;
        int end = n-1;
        if(n > 1){
            for(int i=0; i<s; i++){
                if(isComplete()) break;

                int min = findMin();
                int max = findMax();

                if(max-min < s){
                    swap(min, max);
                    s -= (n-1);
                    continue;
                }

                if(numbers[start] < numbers[start+1]){
                    swap(start, start+1);
                    realStart += 1;
                }
                else{
                    if(start < n-1){
                        while(numbers[start] > numbers[start+1]){
                            if(start < n-2) start += 1;
                            else break;
                        }
                        if(numbers[start] > numbers[start+1]) break;
                    }
                    else break;

                    swap(start, start+1);
                    realStart += 1;
                }
                start = realStart;
            }
        }

        for(int i=0; i<n; i++) sb.append(numbers[i]).append(" ");

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void swap(int idx1, int idx2){
        int temp = numbers[idx1];
        numbers[idx1] = numbers[idx2];
        numbers[idx2] = temp;
    }

    static boolean isComplete(){
        for(int i=0; i<n-1; i++){
            if(numbers[i] < numbers[i+1]) return false;    
        }
        return true;
    }

    static int findMin(){
        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(numbers[i] < min){
                min = numbers[i];
                result = i;
            }
        }
        return result;
    }

    static int findMax(){
        int result = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(numbers[i] > max){
                max = numbers[i];
                result = i;
            }
        }
        return result;
    }
}