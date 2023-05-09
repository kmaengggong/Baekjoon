import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260DFSBFS{
    public static ArrayList<Integer>[] vertexes;
    public static boolean[] dfsVisited;
    public static boolean[] bfsVisited;
    public static StringBuffer sb;

    public static void dFS(int v){
        if(dfsVisited[v]) return;
        dfsVisited[v] = true;
        sb.append(v).append(" ");
        for(int i : vertexes[v]){
            if(!dfsVisited[i]){
                dFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 정점 개수
        int m = Integer.parseInt(st.nextToken());  // 간선 개수
        int v = Integer.parseInt(st.nextToken());  // 시작 정점

        vertexes = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            vertexes[i] = new ArrayList<Integer>();
        }

        int a, b;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            vertexes[a].add(b);
            vertexes[b].add(a);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(vertexes[i]);
        }

        // Logic

        Queue<Integer> queue = new LinkedList<>();
        dfsVisited = new boolean[n+1];
        bfsVisited = new boolean[n+1];

        dFS(v);

        sb.append("\n");

        bfsVisited[v] = true;
        queue.add(v);
        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now).append(" ");
            for(int sub : vertexes[now]){
                if(!bfsVisited[sub]){
                    bfsVisited[sub] = true;
                    queue.add(sub);
                }
            }
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

/* 정답코드: 232ms -> 

 */