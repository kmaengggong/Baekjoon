import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2583AreaGet{
    static StringBuffer sb;
    static int m, n, k, area;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m+2][n+2];
        visited = new boolean[m+2][n+2];

        for(int i=0; i<n+2; i++){
            visited[0][i] = true;
            visited[m+1][i] = true;
        }
        for(int i=0; i<m+2; i++){
            visited[i][0] = true;
            visited[i][n+1] = true;
        }
        
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            
            int x0 = Integer.parseInt(st.nextToken())+1;
            int y0 = m-Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = m-Integer.parseInt(st.nextToken())+1;

            for(int y=y1; y<=y0; y++){
                for(int x=x0; x<=x1; x++){
                    visited[y][x] = true;
                }
            }
        }

        // Logic
        int count = 0;
        pq = new PriorityQueue<>();

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(!visited[i][j]){
                    count += 1;
                    area = 0;
                    dfs(i, j);
                    pq.add(area);
                }
            }
        }

        sb.append(count).append("\n");
        while(!pq.isEmpty()) sb.append(pq.poll()).append(" ");

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        area += 1;

        if(!visited[x-1][y]){
            visited[x-1][y] = true;
            dfs(x-1, y);
        }
        if(!visited[x][y-1]){
            visited[x][y-1] = true;
            dfs(x, y-1);
        }
        if(!visited[x+1][y]){
            visited[x+1][y] = true;
            dfs(x+1, y);
        }
        if(!visited[x][y+1]){
            visited[x][y+1] = true;
            dfs(x, y+1);
        }
    }
}