import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 35min
public class P23747Ward{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r+2][c+2];

        for(int i=1; i<=r; i++){
            char[] line = br.readLine().toCharArray();
            for(int j=1; j<=c; j++){
                map[i][j] = line[j-1];
            }
        }

        st = new StringTokenizer(br.readLine());
        int hr = Integer.parseInt(st.nextToken());
        int hc = Integer.parseInt(st.nextToken());

        char[] history = br.readLine().toCharArray();

        // Logic
        boolean[][] blocked = new boolean[r+2][c+2];
        for(int i=0; i<=r+1; i++){
            blocked[i][0] = true;
            blocked[i][c+1] = true;
        }
        for(int j=0; j<=c+1; j++){
            blocked[0][j] = true;
            blocked[r+1][j] = true;
        }

        int hLen = history.length;
        boolean[][] sight = new boolean[r+2][c+2];

        for(int i=0; i<hLen; i++){
            if(history[i] == 'U'){
                if(!blocked[hr-1][hc]) hr -= 1;
            }
            else if(history[i] == 'D'){
                if(!blocked[hr+1][hc]) hr += 1;
            }
            else if(history[i] == 'L'){
                if(!blocked[hr][hc-1]) hc -= 1;
            }
            else if(history[i] == 'R'){
                if(!blocked[hr][hc+1]) hc += 1;
            }
            else if(history[i] == 'W'){
                Queue<Integer[]> bfs = new LinkedList<>();
                char area = map[hr][hc];
                bfs.add(new Integer[]{hr, hc});

                while(!bfs.isEmpty()){
                    int x = bfs.peek()[0];
                    int y = bfs.poll()[1];
                    sight[x][y] = true;

                    if(!sight[x-1][y] && !blocked[x-1][y] && map[x-1][y] == area){
                        bfs.add(new Integer[]{x-1, y});
                        sight[x-1][y] = true;
                    }
                    if(!sight[x+1][y] &&!blocked[x+1][y] && map[x+1][y] == area){
                        bfs.add(new Integer[]{x+1, y});
                        sight[x+1][y] = true;
                    }
                    if(!sight[x][y-1] && !blocked[x][y-1] && map[x][y-1] == area){
                        bfs.add(new Integer[]{x, y-1});
                        sight[x][y-1] = true;
                    }
                    if(!sight[x][y+1] && !blocked[x][y+1] && map[x][y+1] == area){
                        bfs.add(new Integer[]{x, y+1});
                        sight[x][y+1] = true;
                    }
                }
            }
        }

        sight[hr][hc] = true;
        sight[hr-1][hc] = true;
        sight[hr+1][hc] = true;
        sight[hr][hc-1] = true;
        sight[hr][hc+1] = true;

        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                if(sight[i][j]) sb.append(".");
                else sb.append("#");
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