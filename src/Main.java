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
    static StringBuffer sb = new StringBuffer();
    static int n;
    static int[] pop;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        
        pop = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) pop[i] = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for(int j=1; j<=m; j++) map[i].add(Integer.parseInt(st.nextToken()));
        }

        // Logic
        for(int i=1; i<=n; i++){
            bfs(i);
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int num){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(num);
        visited[num] = true;
        int sum1 = pop[num];

        while(!queue.isEmpty()){
            for(int i : map[num]){
                if(!visited[i]){
                    queue.add(i);
                    sum1 += pop[i];
                }
            }
            
        }
    }
}