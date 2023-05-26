import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023ABCDE{
    public static StringBuffer sb = new StringBuffer();
    public static int n;
    public static ArrayList<Integer>[] nodes;
    public static boolean[] visited;
    public static boolean isEnd = false;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n];
        for(int i=0; i<n; i++) nodes[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            nodes[n1].add(n2);
            nodes[n2].add(n1);
        }

        // Logic
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(isEnd) break;
            dfs(i, 1);
        }

        if(isEnd) sb.append(1);
        else sb.append(0);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int len){
        if(isEnd) return;

        if(len == 4){
            for(int i : nodes[num]){
                if(!visited[i]) isEnd = true;
            }
        }
        else{
            visited[num] = true;
            for(int i : nodes[num]){
                if(!visited[i]){
                    dfs(i, len+1);
                }
            }
            visited[num] = false;
        }
    }
}