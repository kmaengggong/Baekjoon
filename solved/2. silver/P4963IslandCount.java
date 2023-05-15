import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P4963IslandCount{
    public static StringBuffer sb = new StringBuffer();
    public static int map[][];
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        // Logic
        while(!(w == 0 && h == 0)){
            map = new int[h+2][w+2];
            visited = new boolean[h+2][w+2];
            int count = 0;

            for(int i=1; i<=h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<=h+1; i++){
                map[i][0] = 0;
                visited[i][0] = true;
                map[i][w+1] = 0;
                visited[i][w+1] = true;
            }

            for(int j=0; j<=w+1; j++){
                map[0][j] = 0;
                visited[0][j] = true;
                map[h+1][0] = 0;
                visited[h+1][0] = true;
            }

            for(int i=1; i<=h; i++){
                for(int j=1; j<=w; j++){
                    if(map[i][j] == 1){
                        if(!visited[i][j]){
                            count += 1;
                            dfs(i, j);
                        }
                    }
                    else{
                        visited[i][j] = true;
                    }
                }
            }

            sb.append(count).append("\n");

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }

        // Output
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int a, int b){
        visited[a][b] = true;
        if(!visited[a-1][b-1]){
            if(map[a-1][b-1] == 1) dfs(a-1, b-1);
            else visited[a-1][b-1] = true;
        }
        if(!visited[a][b-1]){
            if(map[a][b-1] == 1) dfs(a, b-1);
            else visited[a][b-1] = true;
        }
        if(!visited[a-1][b]){
            if(map[a-1][b] == 1) dfs(a-1, b);
            else visited[a-1][b] = true;
        }
        if(!visited[a+1][b-1]){
            if(map[a+1][b-1] == 1) dfs(a+1, b-1);
            else visited[a+1][b-1] = true;
        }
        if(!visited[a-1][b+1]){
            if(map[a-1][b+1] == 1) dfs(a-1, b+1);
            else visited[a-1][b+1] = true;
        }
        if(!visited[a][b+1]){
            if(map[a][b+1] == 1) dfs(a, b+1);
            else visited[a][b+1] = true;
        }
        if(!visited[a+1][b]){
            if(map[a+1][b] == 1) dfs(a+1, b);
            else visited[a+1][b] = true;
        }
        if(!visited[a+1][b+1]){
            if(map[a+1][b+1] == 1) dfs(a+1, b+1);
            else visited[a+1][b+1] = true;
        }
    }
}