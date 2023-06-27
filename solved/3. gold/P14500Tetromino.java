import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14500Tetromino{
    static StringBuffer sb;
    static int n, m, max, a, b;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+2][m+2];
        visited = new boolean[n+2][m+2];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Logic
        for(int i=0; i<n+2; i++){
            visited[i][0] = true;
            visited[i][m+1] = true;
        }
        for(int i=0; i<m+2; i++){
            visited[0][i] = true;
            visited[n+1][i] = true;
        }

        max = Integer.MIN_VALUE;
        for(a=1; a<=n; a++){
            for(b=1; b<=m; b++){
                if(!visited[a][b]){
                    visited[a][b] = true;
                    dfs(a, b, 1, map[a][b]);
                    visited[a][b] = false;
                }
            }
        }

        sb.append(max);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int depth, int sum){
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }

        if(depth == 3){
            if(x+1 < a+2){
                if(y+1 < b+2 && !visited[x+1][y+1]){
                    visited[x+1][y+1] = true;
                    dfs(x+1, y+1, depth+1, sum+map[x+1][y+1]);
                    visited[x+1][y+1] = false;
                }
                if(y-1 > b-2 && !visited[x+1][y-1]){
                    visited[x+1][y-1] = true;
                    dfs(x+1, y-1, depth+1, sum+map[x+1][y-1]);
                    visited[x+1][y-1] = false;
                }
            }
            if(x-1 > a-2){
                if(y+1 < b+2 && !visited[x-1][y+1]){
                    visited[x-1][y+1] = true;
                    dfs(x-1, y+1, depth+1, sum+map[x-1][y+1]);
                    visited[x-1][y+1] = false;
                }
                if(y-1 > b-2 && !visited[x-1][y-1]){
                    visited[x-1][y-1] = true;
                    dfs(x-1, y-1, depth+1, sum+map[x-1][y-1]);
                    visited[x-1][y-1] = false;
                }
            }
        }

        if(!visited[x+1][y]){
            visited[x+1][y] = true;
            dfs(x+1, y, depth+1, sum+map[x+1][y]);
            visited[x+1][y] = false;
        }
        if(!visited[x-1][y]){
            visited[x-1][y] = true;
            dfs(x-1, y, depth+1, sum+map[x-1][y]);
            visited[x-1][y] = false;
        }
        if(!visited[x][y+1]){
            visited[x][y+1] = true;
            dfs(x, y+1, depth+1, sum+map[x][y+1]);
            visited[x][y+1] = false;
        }
        if(!visited[x][y-1]){
            visited[x][y-1] = true;
            dfs(x, y-1, depth+1, sum+map[x][y-1]);
            visited[x][y-1] = false;
        }
    }
}