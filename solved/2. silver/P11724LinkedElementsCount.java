import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P11724LinkedElementsCount{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // Logic
        // DFS
        boolean[] checked = new boolean[n+1];
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i=1; i<=n; i++){
            if(!checked[i]){
                count += 1;
                checked[i] = true;
                stack.push(i);
            } 
            while(!stack.isEmpty()){
                int now = stack.pop();
                int size = graph[now].size();
                for(int j=0; j<size; j++){
                    int sub = graph[now].get(j);
                    if(!checked[sub]){
                        stack.push(sub);
                        checked[sub] = true;
                    }
                }
            }
        }
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

/* 정답코드: 664ms -> 704ms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static ArrayList<Integer>[] a;
    static boolean visited[];

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<n+1; i++){
            a[i] = new ArrayList<Integer>();
        }

        // Logic
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
            a[e].add(s);
        }

        int count = 0;
        for(int i=1; i<n+1; i++){
            if(!visited[i]){
                count += 1;
                dFS(i);
            }
        }
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dFS(int v){
        if(visited[v]) return;
        visited[v] = true;
        for(int i : a[v]){
            if(visited[i] == false) dFS(i);
        }
    }
}
 */