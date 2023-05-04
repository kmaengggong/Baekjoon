import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        // Logic
        if(l == 1){
            for(int i=0; i<n; i++){
                sb.append(Integer.parseInt(st.nextToken())).append(" ");
            }
        }
        else {
            Deque<Integer> mins = new LinkedList<>();

            int in = Integer.parseInt(st.nextToken());
            mins.add(in);
            sb.append(in).append(" ");
            
            in = Integer.parseInt(st.nextToken());
            if(in < mins.peek()) mins.addFirst(in);
            else mins.addLast(in);
            sb.append(mins.peekFirst()).append(" ");

            for(int i=2; i<l; i++){
                in = Integer.parseInt(st.nextToken());
                while(in < mins.peekLast()){
                    mins.addLast(in);
                }
                sb.append(mins.peekFirst()).append(" ");
            }

            for(int i=l; i<n; i++){
                mins.pollFirst();
                in = Integer.parseInt(st.nextToken());
                if(in < mins.peek()){
                    mins.addFirst(in);
                }
                else mins.addLast(in);
                sb.append(mins.peekFirst()).append(" ");
            }
        }
        
        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}