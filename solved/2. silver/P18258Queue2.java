import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P18258Queue2{
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Deque<Integer> deq = new LinkedList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            
            switch(input){
                case "push":
                    deq.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(deq.isEmpty()) sb.append("-1\n");
                    else sb.append(deq.poll()).append("\n");
                    break;
                case "size":
                    sb.append(deq.size()).append("\n");
                    break;
                case "empty":
                    if(deq.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if(deq.isEmpty()) sb.append("-1\n");
                    else sb.append(deq.peek()).append("\n");
                    break;
                case "back":
                    if(deq.isEmpty()) sb.append("-1\n");
                    else sb.append(deq.peekLast()).append("\n");
                    break;
            }
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
;    }
}