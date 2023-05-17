import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class P2178MazeExplore{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int m = Integer.parseInt(lines[1]);

        int[][] map = new int[n+2][m+2];
        boolean[][] visitied = new boolean[n+2][m+2];

        for(int i=0; i<=m+1; i++){
            visitied[0][i] = true;
            visitied[n+1][i] = true;
        }
        for(int j=0; j<=n+1; j++){
            visitied[j][0] = true;
            visitied[j][m+1] = true;
        }

        for(int i=1; i<=n; i++){
            char[] block = br.readLine().toCharArray();
            for(int j=1; j<=m; j++){
                map[i][j] = block[j-1]-48;
            }
        }

        // Logic
        Queue<Integer[]> queue = new LinkedList<>();
        Queue<Integer[]> queue2 = new LinkedList<>();
        queue.add(new Integer[]{1, 1});

        int x, y;
        int count = 0;
        outer: while(!(queue.isEmpty() && queue2.isEmpty())){
            count += 1;
            while(!queue.isEmpty()){
                x = queue.peek()[0];
                y = queue.poll()[1];
                if(x == n && y == m){
                    queue.clear();
                    queue2.clear();
                    break outer;
                }
    
                if(!visitied[x+1][y]){
                    if(map[x+1][y] == 1){
                        queue2.add(new Integer[]{x+1, y});
                        visitied[x+1][y] = true;
                    }
                    else visitied[x+1][y] = true;
                }
                if(!visitied[x][y+1]){
                    if(map[x][y+1] == 1){
                        queue2.add(new Integer[]{x, y+1});
                        visitied[x][y+1] = true;
                    }
                    else visitied[x][y+1] = true;
                }
                if(!visitied[x-1][y]){
                    if(map[x-1][y] == 1){
                        queue2.add(new Integer[]{x-1, y});
                        visitied[x-1][y] = true;
                    }
                    else visitied[x-1][y] = true;
                }
                if(!visitied[x][y-1]){
                    if(map[x][y-1] == 1){
                        queue2.add(new Integer[]{x, y-1});
                        visitied[x][y-1] = true;
                    }
                    else visitied[x][y-1] = true;
                }
            }

            count += 1;
            while(!queue2.isEmpty()){
                x = queue2.peek()[0];
                y = queue2.poll()[1];
                if(x == n && y == m){
                    queue.clear();
                    queue2.clear();
                    break outer;
                }
    
                if(!visitied[x+1][y]){
                    if(map[x+1][y] == 1){
                        queue.add(new Integer[]{x+1, y});
                        visitied[x+1][y] = true;
                    }
                    else visitied[x+1][y] = true;
                }
                if(!visitied[x][y+1]){
                    if(map[x][y+1] == 1){
                        queue.add(new Integer[]{x, y+1});
                        visitied[x][y+1] = true;
                    }
                    else visitied[x][y+1] = true;
                }
                if(!visitied[x-1][y]){
                    if(map[x-1][y] == 1){
                        queue.add(new Integer[]{x-1, y});
                        visitied[x-1][y] = true;
                    }
                    else visitied[x-1][y] = true;
                }
                if(!visitied[x][y-1]){
                    if(map[x][y-1] == 1){
                        queue.add(new Integer[]{x, y-1});
                        visitied[x][y-1] = true;
                    }
                    else visitied[x][y-1] = true;
                }
            }
        }
        
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}