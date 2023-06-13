import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class P16953AToB{
    static StringBuffer sb;
    static long a, b, result;
    static Set<Long> set;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        // Logic
        if(a == b) sb.append("1");
        else{
            result = 0;
            Queue<Long> queue = new LinkedList<>();
            queue.add(a);
            set = new HashSet<>();
            set.add(a);

            bfs(queue, 1);

            sb.append(result);
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(Queue<Long> queue, int depth){
        Queue<Long> queue2 = new LinkedList<>();

        while(!queue.isEmpty()){
            long now = queue.poll();

            long n1 = now*2;
            long n2 = now*10 + 1;

            if(n1 <= b && !set.contains(n1)){
                if(n1 == b){
                    result = depth+1;
                    return;
                }
                queue2.add(n1);
            } 
            if(n2 <= b && !set.contains(n2)){
                if(n2 == b){
                    result = depth+1;
                    return;
                }
                queue2.add(n2);
            }
        }

        if(queue2.isEmpty()){
            result = -1;
            return;
        }

        bfs(queue2, depth+1);
    }
}