import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1922NetworkConnection{
    static StringBuffer sb = new StringBuffer();
    public static int[] unionFind;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        ArrayList<Edge> arr = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 그래프 에지 리스트
            arr.add(new Edge(n1, n2, w));
        }

        // Logic
        unionFind = new int[n+1];
        for(int i=1; i<=n; i++) unionFind[i] = i;

        // 그래프 에지 리스트를 가중치 기준으로 정렬
        Comparator<Edge> com = new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2){
                if(e1.weight == e2.weight) return 0;
                else if(e1.weight > e2.weight) return 1;
                else return -1;
            }
        };
        Collections.sort(arr, com);

        int turn = 1;
        int cost = 0;

        for(Edge e : arr){
            if(turn >= n) break;

            if(find(e.node1) != find(e.node2)){
                int change;
                change = unionFind[e.node2];
                unionFind[e.node2] = unionFind[e.node1];
                for(int i=1; i<=n; i++){
                    if(unionFind[i] == change) unionFind[i] = unionFind[e.node1];
                }

                cost += e.weight;
                turn += 1;
            }
        }
        
        sb.append(cost);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static int find(int x){
        while(unionFind[x] != x) x = unionFind[x];
        return x;
    }
}

class Edge{
    int node1;
    int node2;
    int weight;

    Edge(int node1, int node2, int weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }
}