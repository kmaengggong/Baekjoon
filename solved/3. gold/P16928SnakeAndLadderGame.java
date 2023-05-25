import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16928SnakeAndLadderGame{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int total = n+m;

        int[] map = new int[101];
        int[][] path = new int[101][1];

        for(int i=0; i<total; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            path[start][0] = end;
        }

        // Logic
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[101];
        visited[0] = true;
        int count = 0;

        outer: while(!(queue.isEmpty() && queue2.isEmpty())){
            while(!queue.isEmpty()){
                int now = queue.poll();
                visited[now] = true;

                if(now == 100) break outer;
                
                int way = path[now][0];
                if(way != 0){
                    if(way == 100) break outer;
                    queue.add(way);
                    continue;
                }
                
                for(int i=1; i<=6; i++){
                    if(now+i <= 100 && !visited[now+i]){
                        visited[now+i] = true;
                        queue2.add(now+i);
                    }
                }
            }
            count += 1;
            
            while(!queue2.isEmpty()){
                int now = queue2.poll();
                visited[now] = true;
                
                if(now == 100) break outer;
                
                int way = path[now][0];
                if(way != 0){
                    if(way == 100) break outer;
                    queue2.add(way);
                    continue;
                }
                
                for(int i=1; i<=6; i++){
                    if(now+i <= 100 && !visited[now+i]){
                        visited[now+i] = true;
                        queue.add(now+i);
                    }
                }
            }
            count += 1;
        }
        
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}