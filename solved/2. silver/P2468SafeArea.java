import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class P2468SafeArea{
    static StringBuffer sb;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Integer> pq;
    static int count, alpha;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        map = new int[n+2][n+2];
        pq = new PriorityQueue<>();
        
        StringTokenizer st;
        int now;

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=n; j++){
                now = Integer.parseInt(st.nextToken());
                if(!pq.contains(now)) pq.add(now);
                map[i][j] = now;
            }
        }

        // Logic
        int result = 1;

        while(!pq.isEmpty()){
            alpha = pq.poll();
            count = 0;
            visited = new boolean[n+2][n+2];
            for(int i=0; i<=n+1; i++){
                visited[0][i] = true;
                visited[i][0] = true;
                visited[n+1][i] = true;
                visited[i][n+1] = true;
            }

            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        if(map[i][j] > alpha){
                            count += 1;
                            dfs(i, j);
                        }
                    }
                }
            }

            if(count > result) result = count;
        }
        
        sb.append(result);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y){
        if(!visited[x+1][y]){
            visited[x+1][y] = true;
            if(map[x+1][y] > alpha) dfs(x+1, y);
        }
        if(!visited[x-1][y]){
            visited[x-1][y] = true;
            if(map[x-1][y] > alpha) dfs(x-1, y);
        }
        if(!visited[x][y+1]){
            visited[x][y+1] = true;
            if(map[x][y+1] > alpha) dfs(x, y+1);
        }
        if(!visited[x][y-1]){
            visited[x][y-1] = true;
            if(map[x][y-1] > alpha) dfs(x, y-1);
        }
    }
}