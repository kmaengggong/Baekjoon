import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606Virus{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int v = Integer.parseInt(br.readLine());
        
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<Integer>();

        StringTokenizer st;
        int a, b;

        for(int i=0; i<v; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a == b) continue;
            graph[a].add(b);
            graph[b].add(a);
        }

        // Logic
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        int count = 0;

        while(!queue.isEmpty()){
            for(int com : graph[queue.peek()]){
                if(!visited[com]){
                    queue.add(com);
                    visited[com] = true;
                    count += 1;
                }
            }
            queue.poll();
        }

        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}