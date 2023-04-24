import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P10773Zero{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());

        // 로직
        Stack<Integer> nums = new Stack<>();
        int num;
        int sum = 0;
        for(int i=0; i<k; i++){
            num = Integer.parseInt(br.readLine());
            if(num != 0){
                nums.push(num);
                sum += num;
            }
            else{
                sum -= nums.pop();
            }
        }
        sb.append(sum);

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}