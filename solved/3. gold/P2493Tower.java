import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 50min
public class P2493Tower{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer[]> stack = new Stack<>();

        if(n == 1){
            sb.append(0);
        }
        else{
            stack.add(new Integer[]{1, Integer.parseInt(st.nextToken())});
            sb.append(0).append(" ");
            for(int i=2; i<=n; i++){
                Integer[] in = new Integer[]{i, Integer.parseInt(st.nextToken())};

                while(!stack.isEmpty()){
                    if(stack.peek()[1] >= in[1]){
                        sb.append(stack.peek()[0]).append(" ");
                        break;
                    }
                    else stack.pop();
                }
                if(stack.isEmpty()) sb.append(0).append(" ");

                stack.push(in);
            }
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}