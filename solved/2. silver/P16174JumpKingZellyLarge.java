import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16174JumpKingZellyLarge{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];
        StringTokenizer st;

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Logic
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] visitied = new boolean[n+1][n+1];
        queue.add(new Integer[]{1, 1});
        int x, y, jump;
        boolean isHing = true;

        while(!queue.isEmpty()){
            x = queue.peek()[0];
            y = queue.poll()[1];
            jump = map[x][y];

            if(visitied[x][y]) continue;
            visitied[x][y] = true;

            if(x == n && y == n){
                isHing = false;
                break;
            }

            if(x+jump <= n) queue.add(new Integer[]{x+jump, y});
            if(y+jump <= n) queue.add(new Integer[]{x, y+jump});
        }

        if(isHing) sb.append("Hing");
        else sb.append("HaruHaru");

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}