import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11725TreeParentFind{
    static StringBuffer sb;
    static int n, find;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        result = new int[n+1];

        for(int i=1; i<=n; i++) list[i] = new ArrayList<>();

        int x, y;
        StringTokenizer st;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        // Logic
        dfs(1);

        for(int i=2; i<=n; i++) sb.append(result[i]).append("\n");

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int num){
        visited[num] = true;

        for(int l : list[num]){
            if(!visited[l]){
                visited[l] = true;
                result[l] = num;
                dfs(l);
            }
        }
    }
}