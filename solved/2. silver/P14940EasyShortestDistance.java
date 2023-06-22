import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14940EasyShortestDistance{
    static StringBuffer sb;
    static int n, m;
    static int[][] map;
    static int[][] resultMap;
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
        resultMap = new int[n+2][m+2];
        
        for(int i=0; i<m+2; i++){
            visited[0][i] = true;
            visited[n+1][i] = true;
        }
        for(int i=0; i<n+2; i++){
            visited[i][0] = true;
            visited[i][m+1] = true;
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Logic
        int[] start = new int[2];

        outer:for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j] == 2){
                    start[0] = i;
                    start[1] = j;
                    break outer;
                }
            }
        }

        bfs(start);

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    sb.append("-1 ");
                }
                else{
                    sb.append(resultMap[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(int[] xy){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(xy);
        visited[xy[0]][xy[1]] = true;
        int x, y;

        while(!queue.isEmpty()){
            x = queue.peek()[0];
            y = queue.poll()[1];

            if(!visited[x+1][y]){
                visited[x+1][y] = true;
                if(map[x+1][y] == 1){
                    resultMap[x+1][y] = resultMap[x][y]+1;
                    queue.add(new int[]{x+1, y});
                }
            }
            if(!visited[x-1][y]){
                visited[x-1][y] = true;
                if(map[x-1][y] == 1){
                    resultMap[x-1][y] = resultMap[x][y]+1;
                    queue.add(new int[]{x-1, y});
                }
            }
            if(!visited[x][y+1]){
                visited[x][y+1] = true;
                if(map[x][y+1] == 1){
                    resultMap[x][y+1] = resultMap[x][y]+1;
                    queue.add(new int[]{x, y+1});
                }
            }
            if(!visited[x][y-1]){
                visited[x][y-1] = true;
                if(map[x][y-1] == 1){
                    resultMap[x][y-1] = resultMap[x][y]+1;
                    queue.add(new int[]{x, y-1});
                }
            }
        }
    }
}