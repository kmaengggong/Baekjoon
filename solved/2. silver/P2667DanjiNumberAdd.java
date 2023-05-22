import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class P2667DanjiNumberAdd{
    public static StringBuffer sb = new StringBuffer();
    public static boolean[][] visited;
    public static int[][] map;
    public static int count;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        map = new int[n+2][n+2];
        char[] lines;

        for(int i=1; i<=n; i++){
            lines = br.readLine().toCharArray();
            for(int j=0; j<n; j++){
                map[i][j+1] = lines[j] - 48;
            }
        }

        // Logic
        visited = new boolean[n+2][n+2];
        for(int i=0; i<n+2; i++){
            visited[i][0] = true;
            visited[0][i] = true;
            visited[i][n+1] = true;
            visited[n+1][i] = true;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    if(map[i][j] == 1){
                        count = 1;
                        dfs(i, j);
                        pq.add(count);
                    }
                }
            }
        }

        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y){
        if(!visited[x-1][y]){
            visited[x-1][y] = true;
            if(map[x-1][y] == 1){
                dfs(x-1, y);
                count += 1;
            }
        }
        if(!visited[x][y-1]){
            visited[x][y-1] = true;
            if(map[x][y-1] == 1){
                dfs(x, y-1);
                count += 1;
            }
        }
        if(!visited[x+1][y]){
            visited[x+1][y] = true;
            if(map[x+1][y] == 1){
                dfs(x+1, y);
                count += 1;
            }
        }
        if(!visited[x][y+1]){
            visited[x][y+1] = true;
            if(map[x][y+1] == 1){
                dfs(x, y+1);
                count += 1;
            }
        }
    }
}