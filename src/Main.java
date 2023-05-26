import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static StringBuffer sb = new StringBuffer();
    public static ArrayList<Integer[]>[] nodes;
    public static boolean[] visited;
    public static int max = Integer.MIN_VALUE;
    public static int sum = 0;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        nodes = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++) nodes[i] = new ArrayList<Integer[]>();

        StringTokenizer st;

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int input = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = new LinkedList<>();

            while(input != -1){
                if(queue.size() == 2){
                    nodes[i].add(new Integer[]{queue.poll(), queue.poll()});
                }
                else queue.add(input);
                input = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=n; i++){
            for(Integer[] node : nodes[i]){
                System.out.println(i + ": " + node[0] + ", " + node[1]);
            }
        }

        // Logic
        for(int i=1; i<=n; i++){
            dfs(i);
        }

        sb.append(max);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int num){
        boolean isEnd = true;
        visited[num] = true; 

        for(Integer[] node : nodes[num]){
            if(!visited[num]){
                isEnd = false;
                sum += node[1];
                dfs(node[0]);
                sum -= node[1];
            }  
        }
        if(isEnd){
            if(sum > max) max = sum;
        }

        visited[num] = false;
    }
}