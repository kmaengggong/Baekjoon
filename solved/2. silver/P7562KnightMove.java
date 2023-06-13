import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562KnightMove{
    static StringBuffer sb;
    static int l, x0, y0, answer;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x0 = Integer.parseInt(st.nextToken());
            y0 = Integer.parseInt(st.nextToken());

            if(isAnswer(x, y)){
                sb.append("0\n");
                continue;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(x, y));

            // Logic
            bfs(queue, 0);

            sb.append(answer).append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(Queue<Node> queue, int depth){
        Queue<Node> queue2 = new LinkedList<>();

        while(!queue.isEmpty()){
            int x = queue.peek().x;
            int y = queue.poll().y;

            if(isValid(x+1)){
                if(isValid(y+2) && !visited[x+1][y+2]){
                    if(isAnswer(x+1, y+2)){
                        answer = depth+1;
                        return;
                    }
                    visited[x+1][y+2] = true;
                    queue2.add(new Node(x+1, y+2));
                }
                if(isValid(y-2) && !visited[x+1][y-2]){
                    if(isAnswer(x+1, y-2)){
                        answer = depth+1;
                        return;
                    }
                    visited[x+1][y-2] = true;
                    queue2.add(new Node(x+1, y-2));
                }
                if(isValid(x+2)){
                    if(isValid(y+1) && !visited[x+2][y+1]){
                        if(isAnswer(x+2, y+1)){
                            answer = depth+1;
                            return;
                        }
                        visited[x+2][y+1] = true;
                        queue2.add(new Node(x+2, y+1));
                    }
                    if(isValid(y-1) && !visited[x+2][y-1]){
                        if(isAnswer(x+2, y-1)){
                            answer = depth+1;
                            return;
                        }
                        visited[x+2][y-1] = true;
                        queue2.add(new Node(x+2, y-1));
                    }
                }
            }
            if(isValid(x-1)){
                if(isValid(y+2) && !visited[x-1][y+2]){
                    if(isAnswer(x-1, y+2)){
                        answer = depth+1;
                        return;
                    }
                    visited[x-1][y+2] = true;
                    queue2.add(new Node(x-1, y+2));
                }
                if(isValid(y-2) && !visited[x-1][y-2]){
                    if(isAnswer(x-1, y-2)){
                        answer = depth+1;
                        return;
                    }
                    visited[x-1][y-2] = true;
                    queue2.add(new Node(x-1, y-2));
                }
                if(isValid(x-2)){
                    if(isValid(y+1) && !visited[x-2][y+1]){
                        if(isAnswer(x-2, y+1)){
                            answer = depth+1;
                            return;
                        }
                        visited[x-2][y+1] = true;
                        queue2.add(new Node(x-2, y+1));
                    }
                    if(isValid(y-1) && !visited[x-2][y-1]){
                        if(isAnswer(x-2, y-1)){
                            answer = depth+1;
                            return;
                        }
                        visited[x-2][y-1] = true;
                        queue2.add(new Node(x-2, y-1));
                    }
                }
            }
        }

        bfs(queue2, depth+1);
    }

    static boolean isValid(int a){
        if(a >= 0 && a < l) return true;
        return false;
    }

    static boolean isAnswer(int x, int y){
        if(x == x0 && y == y0) return true;
        return false;
    }
}

class Node{
    public int x;
    public int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}