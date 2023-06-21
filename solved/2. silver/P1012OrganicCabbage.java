import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1012OrganicCabbage{
    static StringBuffer sb;
    static int m, n, k;
    static int[][] field;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            field = new int[m+2][n+2];
            visited = new boolean[m+2][n+2];

            for(int j=0; j<n+2; j++){
                visited[0][j] = true;
                visited[m+1][j] = true;
            }
            for(int j=0; j<m+2; j++){
                visited[j][0] = true;
                visited[j][n+1] = true;
            }
            
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                field[Integer.parseInt(st.nextToken())+1][Integer.parseInt(st.nextToken())+1] = 1;
            }

            // Logic
            int count = 0;

            for(int j=1; j<=m; j++){
                for(int k=1; k<=n; k++){
                    if(!visited[j][k] && field[j][k] == 1){
                        count += 1;
                        visited[j][k] = true;
                        dfs(j, k);
                    }
                }
            }

            sb.append(count).append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y){
        if(!visited[x+1][y] && field[x+1][y] == 1){
            visited[x+1][y] = true;
            dfs(x+1, y);
        }
        if(!visited[x][y+1] && field[x][y+1] == 1){
            visited[x][y+1] = true;
            dfs(x, y+1);
        }
        if(!visited[x-1][y] && field[x-1][y] == 1){
            visited[x-1][y] = true;
            dfs(x-1, y);
        }
        if(!visited[x][y-1] && field[x][y-1] == 1){
            visited[x][y-1] = true;
            dfs(x, y-1);
        }
    }
}