import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2644ChonsuCalculate{
    static StringBuffer sb;
    static int a, b, depth, result;
    static List<Integer>[] jokbo;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        jokbo = new ArrayList[n+1];
        for(int i=1; i<=n; i++) jokbo[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            jokbo[x].add(y);
            jokbo[y].add(x);
        }

        // Logic
        visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        result = -1;
        depth = 1;
        bfs(queue);

        sb.append(result);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(Queue<Integer> queue){
        Queue<Integer> queue2 = new LinkedList<>();

        while(!queue.isEmpty()){
            int now = queue.poll();
            visited[now] = true;

            for(int i : jokbo[now]){
                if(!visited[i]){
                    if(i == b){
                        result = depth;
                        return;
                    }
                    queue2.add(i);
                }
            }
        }

        depth += 1;
        if(!queue2.isEmpty()) bfs(queue2);
    }
}