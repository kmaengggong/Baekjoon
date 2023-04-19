import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    static int n;
    static int m;
    static int result = Integer.MAX_VALUE;
    public static int moveNext(int[][] maze, int[] now, int count, int[] prev){
        boolean bothBlock = true;
        //System.out.println("count: " + count);
        //System.out.println("prev: [" + prev[0] + ", " + prev[1] + "]" + "-> now: [" + now[0] + ", " + now[1] + "]");
        if(count == -1) return -1;
        if(now[0] == n-1 && now[1] == m-1){
            //System.out.println("정답 길, " + count);
            if(count != -1 && count < result) result = count;
            //Thread.sleep(1000);
            return -1;
        }
        
        // 오른쪽이 막히지 않았다면 오른쪽으로 이동
        if((now[1] < m-1) && maze[now[0]][now[1]+1] == 1){
            int[] next = moveRight(now.clone());
            if(!(prev[0] == next[0] && prev[1] == next[1])){
                int temp = count;
                count += 1;
                bothBlock = false;
                //System.out.println("moveRight");
                //System.out.println("count: " + count);
                //System.out.println("next: [" + next[0] + ", " + next[1] + "]");
                //System.out.println("--------------------------------------");
                if(count >= result){
                    //System.out.println("찾은 길보다 느리거나 같음");
                    return result;
                }
                count = moveNext(maze, next, count, now.clone());
                if(count == -1) count = temp;
            }
        }
        // 아래쪽이 막히지 않았다면 아래쪽으로 이동
        if((now[0] < n-1) && maze[now[0]+1][now[1]] == 1){
            int[] next = moveDown(now.clone());
            if(!(prev[0] == next[0] && prev[1] == next[1])){
                int temp = count;
                count += 1;
                bothBlock = false;
                //System.out.println("moveDown");
                //System.out.println("count: " + count);
                //System.out.println("next: [" + next[0] + ", " + next[1] + "]");
                //System.out.println("--------------------------------------");
                
                count = moveNext(maze, next, count, now.clone());
                if(count == -1) count = temp;
            }
        }
        // 오른쪽, 왼쪽이 막혔다면
        if(bothBlock){
            if((now[1] > 0) && maze[now[0]][now[1]-1] == 1){
                int[] next = moveLeft(now.clone());
                if(!(prev[0] == next[0] && prev[1] == next[1])){
                    int temp = count;
                    count += 1;
                    bothBlock = false;
                    //System.out.println("moveLeft");
                    //System.out.println("count: " + count);
                    //System.out.println("next: [" + next[0] + ", " + next[1] + "]");
                    //System.out.println("--------------------------------------");
                    
                    count = moveNext(maze, next, count, now.clone());
                    if(count == -1) count = temp;
                }
            }
            if((now[0] > 0) && maze[now[0]-1][now[1]] == 1){
                int[] next = moveUp(now.clone());
                if(!(prev[0] == next[0] && prev[1] == next[1])){
                    int temp = count;
                    count += 1;
                    bothBlock = false;
                    //System.out.println("moveUp");
                    //System.out.println("count: " + count);
                    //System.out.println("next: [" + next[0] + ", " + next[1] + "]");
                    //System.out.println("--------------------------------------");
                    
                    count = moveNext(maze, next, count, now.clone());
                    if(count == -1) count = temp;
                }
            }
        }
        //System.out.println("막힌 길");
        return -1;
    }
    public static int[] moveUp(int[] now){
        now[0] -= 1;
        return now;
    }
    public static int[] moveDown(int[] now){
        now[0] += 1;
        return now;
    }
    public static int[] moveRight(int[] now){
        now[1] += 1;
        return now;
    }
    public static int[] moveLeft(int[] now){
        now[1] -= 1;
        return now;
    }
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lines = br.readLine().split(" ");
        n = Integer.parseInt(lines[0]);  // 나무의 갯수
        m = Integer.parseInt(lines[1]);  // 가져가려고 하는 나무의 길이

        int[][] maze = new int[n][m];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                maze[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        // 로직
        int[] nowXY = new int[2];
        int[] prev = {-1, -1};
        int count = 1;
        int x = moveNext(maze, nowXY, count, prev);

        // 출력
        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
 }