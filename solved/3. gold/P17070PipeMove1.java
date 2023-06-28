import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P17070PipeMove1{
    static StringBuffer sb;
    static int n, count;
    static int[][] graph;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());
        
        graph = new int[n+2][n+2];
        StringTokenizer st;

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Logic
        for(int i=0; i<n+2; i++){
            graph[i][n+1] = 1;
            graph[n+1][i] = 1;
        }

        count = 0;
        dfs(1, 2, -1);
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    // z - -1: 가로, 0: 대각선, 1: 세로
    static void dfs(int x, int y, int z){
        if(x == n && y == n){
            count += 1;
            return;
        }

        boolean isX = false;
        boolean isY = false;
        boolean isZ = false;
        if(graph[x+1][y] == 0) isX = true;
        if(graph[x][y+1] == 0) isY = true;
        if(graph[x+1][y+1] == 0) isZ = true;

        if(z <= 0){
            if(isY) dfs(x, y+1, -1);
        }
        if(isX && isY && isZ) dfs(x+1, y+1, 0);
        if(z >= 0){
            if(isX) dfs(x+1, y, 1);
        }
    }
}