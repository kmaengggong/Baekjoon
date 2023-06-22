import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5014StartLink{
    static StringBuffer sb;
    static int f, s, g, u, d;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // Logic
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited = new boolean[f+1];
        visited[0] = true;
        visited[s] = true;
        int floor;
        int[] count = new int[f+1];

        while(!queue.isEmpty()){
            floor = queue.poll();

            if(isValid(floor+u) && !visited[floor+u]){
                visited[floor+u] = true;
                count[floor+u] = count[floor]+1;
                queue.add(floor+u);
            }
            if(isValid(floor-d) && !visited[floor-d]){
                visited[floor-d] = true;
                count[floor-d] = count[floor]+1;
                queue.add(floor-d);
            }
        }

        if(!visited[g]) sb.append("use the stairs");
        else sb.append(count[g]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isValid(int x){
        if(x > f || x < 1) return false;
        return true;
    }
}