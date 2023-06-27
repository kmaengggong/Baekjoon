import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static StringBuffer sb;
    static int n, m, h;
    static int[][][] boxes;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        boxes = new int[m+2][n+2][h+2];
        visited = new boolean[m+2][n+2][h+2];

        for(int i=1; i<=h; i++){
            for(int j=1; j<=m; j++){
                st = new StringTokenizer(br.readLine());

                for(int k=1; k<=n; k++){
                    boxes[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // Logic
        for(int i=0; i<h+2; i++){
            for(int j=0; j<m+2; j++){
                visited[j][0][i] = true;
                visited[j][n+1][i] = true;        
            }
            for(int j=0; j<n+2; j++){
                visited[0][j][i] = true;
                visited[m+1][j][i] = true;
            }
        }
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                visited[i][j][0] = true;
                visited[i][j][h+1] = true;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();
        for(int i=1; i<=h; i++){
            for(int j=1; j<=m; j++){
                for(int k=1; k<=n; k++){
                    if(boxes[j][k][i] == 1){
                        queue.add(new int[]{j, k, i});
                        visited[j][k][i] = true;
                    }
                    else if(boxes[j][k][i] == -1){
                        visited[j][k][i] = true;
                    }
                }
            }
        }

        int result = 0;
        if(isAllRotten()) sb.append(result);
        else{
            while(!queue.isEmpty() || !queue2.isEmpty()){
                while(!queue.isEmpty()){
                    int[] now = queue.poll();
                    
                    if(!visited[now[0]+1][now[1]][now[2]]){
                        visited[now[0]+1][now[1]][now[2]] = true;
                        if(boxes[now[0]+1][now[1]][now[2]] == 0){
                            boxes[now[0]+1][now[1]][now[2]] = 1;
                            queue2.add(new int[]{now[0]+1, now[1], now[2]});
                        }
                    } 
                    if(!visited[now[0]-1][now[1]][now[2]]){
                        visited[now[0]-1][now[1]][now[2]] = true;
                        if(boxes[now[0]-1][now[1]][now[2]] == 0){
                            boxes[now[0]-1][now[1]][now[2]] = 1;
                            queue2.add(new int[]{now[0]-1, now[1], now[2]});
                        }
                    } 
                    if(!visited[now[0]][now[1]+1][now[2]]){
                        visited[now[0]][now[1]+1][now[2]] = true;
                        if(boxes[now[0]][now[1]+1][now[2]] == 0){
                            boxes[now[0]][now[1]+1][now[2]] = 1;
                            queue2.add(new int[]{now[0], now[1]+1, now[2]});
                        }
                    } 
                    if(!visited[now[0]][now[1]-1][now[2]]){
                        visited[now[0]][now[1]-1][now[2]] = true;
                        if(boxes[now[0]][now[1]-1][now[2]] == 0){
                            boxes[now[0]][now[1]-1][now[2]] = 1;
                            queue2.add(new int[]{now[0], now[1]-1, now[2]});
                        }
                    } 
                    if(!visited[now[0]][now[1]][now[2]+1]){
                        visited[now[0]][now[1]][now[2]+1] = true;
                        if(boxes[now[0]][now[1]][now[2]+1] == 0){
                            boxes[now[0]][now[1]][now[2]+1] = 1;
                            queue2.add(new int[]{now[0], now[1], now[2]+1});
                        }
                    } 
                    if(!visited[now[0]][now[1]][now[2]-1]){
                        visited[now[0]][now[1]][now[2]-1] = true;
                        if(boxes[now[0]][now[1]][now[2]-1] == 0){
                            boxes[now[0]][now[1]][now[2]-1] = 1;
                            queue2.add(new int[]{now[0], now[1], now[2]-1});
                        }
                    }
                }
                result += 1;
                if(isAllRotten()) break;

                while(!queue2.isEmpty()){
                    int[] now = queue2.poll();
                    
                    if(!visited[now[0]+1][now[1]][now[2]]){
                        visited[now[0]+1][now[1]][now[2]] = true;
                        if(boxes[now[0]+1][now[1]][now[2]] == 0){
                            boxes[now[0]+1][now[1]][now[2]] = 1;
                            queue.add(new int[]{now[0]+1, now[1], now[2]});
                        }
                    } 
                    if(!visited[now[0]-1][now[1]][now[2]]){
                        visited[now[0]-1][now[1]][now[2]] = true;
                        if(boxes[now[0]-1][now[1]][now[2]] == 0){
                            boxes[now[0]-1][now[1]][now[2]] = 1;
                            queue.add(new int[]{now[0]-1, now[1], now[2]});
                        }
                    } 
                    if(!visited[now[0]][now[1]+1][now[2]]){
                        visited[now[0]][now[1]+1][now[2]] = true;
                        if(boxes[now[0]][now[1]+1][now[2]] == 0){
                            boxes[now[0]][now[1]+1][now[2]] = 1;
                            queue.add(new int[]{now[0], now[1]+1, now[2]});
                        }
                    } 
                    if(!visited[now[0]][now[1]-1][now[2]]){
                        visited[now[0]][now[1]-1][now[2]] = true;
                        if(boxes[now[0]][now[1]-1][now[2]] == 0){
                            boxes[now[0]][now[1]-1][now[2]] = 1;
                            queue.add(new int[]{now[0], now[1]-1, now[2]});
                        }
                    } 
                    if(!visited[now[0]][now[1]][now[2]+1]){
                        visited[now[0]][now[1]][now[2]+1] = true;
                        if(boxes[now[0]][now[1]][now[2]+1] == 0){
                            boxes[now[0]][now[1]][now[2]+1] = 1;
                            queue.add(new int[]{now[0], now[1], now[2]+1});
                        }
                    } 
                    if(!visited[now[0]][now[1]][now[2]-1]){
                        visited[now[0]][now[1]][now[2]-1] = true;
                        if(boxes[now[0]][now[1]][now[2]-1] == 0){
                            boxes[now[0]][now[1]][now[2]-1] = 1;
                            queue.add(new int[]{now[0], now[1], now[2]-1});
                        }
                    } 
                }
                result += 1;
                if(isAllRotten()) break;
            }
            if(!isAllRotten()) sb.append("-1");
            else sb.append(result);
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isAllRotten(){
        for(int i=1; i<=h; i++){
            for(int j=1; j<=m; j++){
                for(int k=1; k<=n; k++){
                    if(!visited[j][k][i]) return false;
                }
            }
        }

        return true;
    }
}