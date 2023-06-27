import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10026RedGreenColorWeakness{
    static StringBuffer sb;
    static int n, count1, count2;
    static char[][] map, map2;
    static boolean[][] visited, visited2;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        map = new char[n+2][n+2];
        map2 = new char[n+2][n+2];
        visited = new boolean[n+2][n+2];
        visited2 = new boolean[n+2][n+2];

        for(int i=1; i<=n; i++){
            char[] input = br.readLine().toCharArray();

            for(int j=1; j<=n; j++){
                map[i][j] = input[j-1];
                if(input[j-1] == 'G') map2[i][j] = 'R';
                else map2[i][j] = input[j-1];
            }
        }

        // Logic
        for(int i=0; i<n+2; i++){
            visited[i][0] = true;
            visited[i][n+1] = true;
            visited[0][i] = true;
            visited[0][n+1] = true;
            visited2[i][0] = true;
            visited2[i][n+1] = true;
            visited2[0][i] = true;
            visited2[0][n+1] = true;
        }
        
        count1 = 0;
        count2 = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(!visited[i][j]){
                    count1 += 1;
                    visited[i][j] = true;
                    if(map[i][j] == 'R') dfs1(i, j, 'R');
                    else if(map[i][j] == 'G') dfs1(i, j, 'G');
                    else  dfs1(i, j, 'B');
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(!visited2[i][j]){
                    count2 += 1;
                    visited2[i][j] = true;
                    if(map2[i][j] == 'R') dfs2(i, j, 'R');
                    else dfs2(i, j, 'B');
                }
            }
        }

        sb.append(count1).append(" ").append(count2);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs1(int x, int y, char rgb){
        if(!visited[x+1][y] && map[x+1][y] == rgb){
            visited[x+1][y] = true;
            dfs1(x+1, y, rgb);
        }
        if(!visited[x-1][y] && map[x-1][y] == rgb){
            visited[x-1][y] = true;
            dfs1(x-1, y, rgb);
        }
        if(!visited[x][y+1] && map[x][y+1] == rgb){
            visited[x][y+1] = true;
            dfs1(x, y+1, rgb);
        }
        if(!visited[x][y-1] && map[x][y-1] == rgb){
            visited[x][y-1] = true;
            dfs1(x, y-1, rgb);
        }
    }

    static void dfs2(int x, int y, int rgb){
        if(!visited2[x+1][y] && map2[x+1][y] == rgb){
            visited2[x+1][y] = true;
            dfs2(x+1, y, rgb);
        }
        if(!visited2[x-1][y] && map2[x-1][y] == rgb){
            visited2[x-1][y] = true;
            dfs2(x-1, y, rgb);
        }
        if(!visited2[x][y+1] && map2[x][y+1] == rgb){
            visited2[x][y+1] = true;
            dfs2(x, y+1, rgb);
        }
        if(!visited2[x][y-1] && map2[x][y-1] == rgb){
            visited2[x][y-1] = true;
            dfs2(x, y-1, rgb);
        }
    }
}