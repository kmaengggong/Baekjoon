import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576Tomato{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] box = new int[m+2][n+2];
        boolean[][] visited = new boolean[m+2][n+2];
        Queue<Integer[]> queue = new LinkedList<>();

        for(int i=0; i<=n+1; i++){
            box[0][i] = -1;
            visited[0][i] = true;
            box[m+1][i] = -1;
            visited[m+1][i] = true;
        }
        for(int j=0; j<=m+1; j++){
            box[j][0] = -1;
            visited[j][0] = true;
            box[j][n+1] = -1;
            visited[j][n+1] = true;
        }

        int input;
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                input = Integer.parseInt(st.nextToken());
                box[i][j] = input;
                if(input == -1) visited[i][j] = true;
                if(input == 1) queue.add(new Integer[]{i, j});
            }
        }

        // Logic
        Queue<Integer[]> newQueue = new LinkedList<>();
        int count = 0;
        int x, y;

        while(!(queue.isEmpty() && newQueue.isEmpty())){
            boolean isQueueWork = false;
            boolean isNewQueueWork = false;
    
            if(!queue.isEmpty()){
                while(!queue.isEmpty()){
                    x = queue.peek()[0];
                    y = queue.poll()[1];
                    visited[x][y] = true;

                    if(!visited[x-1][y]){
                        if(box[x-1][y] == 0){
                            newQueue.add(new Integer[]{x-1, y});
                            box[x-1][y] = 1;
                            isQueueWork = true;
                        }
                        else if(box[x-1][y] == -1) visited[x-1][y] = true;
                    }
                    if(!visited[x][y-1]){
                        if(box[x][y-1] == 0){
                            newQueue.add(new Integer[]{x, y-1});
                            box[x][y-1] = 1;
                            isQueueWork = true;
                        }
                        else if(box[x][y-1] == -1) visited[x][y-1] = true;
                    }
                    if(!visited[x+1][y]){
                        if(box[x+1][y] == 0){
                            newQueue.add(new Integer[]{x+1, y});
                            box[x+1][y] = 1;
                            isQueueWork = true;
                        }
                        else if(box[x+1][y] == -1) visited[x+1][y] = true;
                    }
                    if(!visited[x][y+1]){
                        if(box[x][y+1] == 0){
                            newQueue.add(new Integer[]{x, y+1});
                            box[x][y+1] = 1;
                            isQueueWork = true;
                        }
                        else if(box[x][y+1] == -1) visited[x][y+1] = true;
                    }
                }

                if(isQueueWork) count += 1;
            }

            if(!newQueue.isEmpty()){
                while(!newQueue.isEmpty()){
                    x = newQueue.peek()[0];
                    y = newQueue.poll()[1];
                    visited[x][y] = true;

                    if(!visited[x-1][y]){
                        if(box[x-1][y] == 0){
                            queue.add(new Integer[]{x-1, y});
                            box[x-1][y] = 1;
                            isNewQueueWork = true;
                        }
                        else if(box[x-1][y] == -1) visited[x-1][y] = true;
                    }
                    if(!visited[x][y-1]){
                        if(box[x][y-1] == 0){
                            queue.add(new Integer[]{x, y-1});
                            box[x][y-1] = 1;
                            isNewQueueWork = true;
                        }
                        else if(box[x][y-1] == -1) visited[x][y-1] = true;
                    }
                    if(!visited[x+1][y]){
                        if(box[x+1][y] == 0){
                            queue.add(new Integer[]{x+1, y});
                            box[x+1][y] = 1;
                            isNewQueueWork = true;
                        }
                        else if(box[x+1][y] == -1) visited[x+1][y] = true;
                    }
                    if(!visited[x][y+1]){
                        if(box[x][y+1] == 0){
                            queue.add(new Integer[]{x, y+1});
                            box[x][y+1] = 1;
                            isNewQueueWork = true;
                        }
                        else if(box[x][y+1] == -1) visited[x][y+1] = true;
                    }
                };
                
                if(isNewQueueWork) count += 1;
            }
        }

        boolean isFinish = true;
        outer: for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(!visited[i][j]){
                    isFinish = false;
                    break outer;
                }
            }
        }
        if(isFinish) sb.append(count);
        else sb.append(-1);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}