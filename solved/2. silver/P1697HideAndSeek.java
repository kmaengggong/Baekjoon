import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697HideAndSeek{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // Logic
        if(n >= k) sb.append(n-k);
        else{
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();
            queue.add(n);

            boolean[] visited = new boolean[k*2];
            visited[n] = true;

            int now;
            int count = 0;

            outer: while(!(queue.isEmpty() && queue2.isEmpty())){
                while(!queue.isEmpty()){
                    now = queue.poll();
                    
                    if(now == k){
                        break outer;
                    }

                    if(now+1 < k*2){
                        if(!visited[now+1]){
                            queue2.add(now+1);
                            visited[now+1] = true;
                        }
                    } 
                    if(now-1 >= 0){
                        if(!visited[now-1]){
                            queue2.add(now-1);
                            visited[now-1] = true;
                        }
                    }
                    if(now*2 < k*2){
                        if(!visited[now*2]){
                            queue2.add(now*2);
                            visited[now*2] = true;
                        }
                    }
                }
                count += 1;

                while(!queue2.isEmpty()){
                    now = queue2.poll();
                    
                    if(now == k){
                        break outer;
                    }

                    if(now+1 < k*2){
                        if(!visited[now+1]){
                            queue.add(now+1);
                            visited[now+1] = true;
                        }
                    } 
                    if(now-1 >= 0){
                        if(!visited[now-1]){
                            queue.add(now-1);
                            visited[now-1] = true;
                        }
                    }
                    if(now*2 < k*2){
                        if(!visited[now*2]){
                            queue.add(now*2);
                            visited[now*2] = true;
                        }
                    }
                }
                count += 1;
            }

            sb.append(count);
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}