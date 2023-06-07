import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1647CitiyDivisionPlan{
    static StringBuffer sb;
    static int n, m;
    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1; i<=n; i++) parent[i] = i;
        pq = new PriorityQueue<>();

        int n1, n2, w;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            pq.add(new Edge(n1, n2, w));
        }

        // Logic
        int turn = 2;
        int result = 0;

        while(turn < n){
            Edge edge = pq.poll();

            if(find(edge.node1) != find(edge.node2)){
                union(edge.node1, edge.node2);
                result += edge.weight;
                turn += 1;
            }
        }

        sb.append(result);

        // Output
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }

    static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
}

class Edge implements Comparable<Edge>{
    int node1;
    int node2;
    int weight;

    Edge(int node1, int node2, int weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge){
        return this.weight - edge.weight;
    }
}