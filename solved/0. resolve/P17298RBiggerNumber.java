public class P17298RBiggerNumber {
    
}

/* 정답코드: 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for(int i=0; i<n; i++) numbers[i] = Integer.parseInt(st.nextToken());
        int[] result = new int[n];

        // Logic
        stack.push(0);
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while(!stack.empty()){
            result[stack.pop()] = -1;
        }
        for(int i=0; i<n; i++){
            bw.write(result[i] + " ");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */
