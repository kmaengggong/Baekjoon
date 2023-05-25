import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11403RouteFind{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Logic
        Queue<Integer> bfs = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0){
                    boolean[] visited = new boolean[n+1];
                    bfs.add(i);
                    outer: while(!bfs.isEmpty()){
                        int q = bfs.poll();
                        for(int k=0; k<n; k++){
                            if(!visited[k] && map[q][k] == 1){
                                bfs.add(k);
                                visited[k] = true;
                                map[i][k] = 1;
                                if(k == j) break outer;
                            }
                        }
                    }
                    bfs.clear();
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}