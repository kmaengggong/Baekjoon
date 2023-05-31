import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P1167TreeRadius{
    public static StringBuffer sb = new StringBuffer();
    public static ArrayList<int[]>[] nodes;
    public static boolean[] visited;
    public static int max = Integer.MIN_VALUE;
    public static int sum = 0;
    public static int maxNum = 0;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        nodes = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++) nodes[i] = new ArrayList<int[]>();

        int start = 0;

        for(int i=1; i<=n; i++){
            String[] lines = br.readLine().split(" ");
            int len = lines.length - 1;
            int num = Integer.parseInt(lines[0]);
            for(int j=1; j<len; j+=2){
                nodes[num].add(new int[]{Integer.parseInt(lines[j]), Integer.parseInt(lines[j+1])});
            }
            if(len == 3) start = num;
        }

        // Logic
        dfs(start);
        sum = 0;
        dfs(maxNum);

        sb.append(max);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int num){
        boolean isEnd = true;
        visited[num] = true;
        
        for(int[] node : nodes[num]){
            if(!visited[node[0]]){
                isEnd = false;
                sum += node[1];
                dfs(node[0]);
                sum -= node[1];
            }
        }
        
        if(isEnd && sum > max){
            max = sum;
            maxNum = num;
        }

        visited[num] = false;
    }
}

/* 정답 코드: 1004ms -> 872ms
* dfs 대신 bfs
* int[] 대신 Node 클래스
* 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static StringBuffer sb = new StringBuffer();
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] arr;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<Edge>();
        }

        StringTokenizer st;

        int s, e, v;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());

            while(true){
                e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                v = Integer.parseInt(st.nextToken());
                arr[s].add(new Edge(e, v));
            }
        }

        // Logic
        distance = new int[n+1];
        visited = new boolean[n+1];
        bfs(1);

        int max = 1;
        for(int i=2; i<=n; i++){
            if(distance[max] < distance[i]) max = i;
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        bfs(max);

        Arrays.sort(distance);
        sb.append(distance[n]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        
        while(!queue.isEmpty()){
            int nowNode = queue.poll();
            for(Edge i : arr[nowNode]){
                int e = i.e;
                int v = i.value;
                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[nowNode] + v;
                }
            }
        }
    }
}

class Edge{
    int e;
    int value;
    
    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }
}
*/