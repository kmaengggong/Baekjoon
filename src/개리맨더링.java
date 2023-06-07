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
    static StringBuffer sb;
    static int n;
    static int[] weight;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int pop1, pop2;
    static int minPop = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();
        
        n = Integer.parseInt(br.readLine());

        weight = new int[n+1];
        arr = new ArrayList[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            weight[i] = Integer.parseInt(st.nextToken());
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j=0; j<m; j++) arr[i].add(Integer.parseInt(st.nextToken()));
        }

        // Logic
        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            pop1 = 0;
            System.out.println();
            bfs(i);
        }

        if(minPop == Integer.MAX_VALUE) sb.append("-1");
        else sb.append(minPop);

        // Output
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isAllVisited(){
        for(int i=1; i<=n; i++) if(!visited[i]) return false;
        return true;
    }

    static int findNotVisited(){
        for(int i=1; i<=n; i++) if(!visited[i]) return i;
        return 0;
    }

    static void bfs(int a){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;
        pop1 += weight[a];

        while(!queue.isEmpty()){
            int num = queue.poll();
            System.out.println(num);
            //visited[num] = true;
            //pop1 += weight[num];
            int left = findNotVisited();
            if(left != 0){
                System.out.println("left: " + left);
                boolean[] tempVisited = visited.clone();
                pop2 = 0;
                dfs(left);

                if(isAllVisited()){
                    System.out.println("diff:" + Math.abs(pop1-pop2));
                    if(Math.abs(pop1-pop2) < minPop) minPop = Math.abs(pop1-pop2);
                }
                visited = tempVisited;
            }

            for(int i : arr[num]){
                if(!visited[i]){
                    visited[i] = true;
                    pop1 += weight[num];
                    queue.add(i);
                }
            }

            //visited[num] = false;
            //pop1 -= weight[num];
        }


        /*visited[a] = true;
        pop1 += weight[a];

        int left = findNotVisited();
        if(left != 0){
            boolean[] tempVisited = visited.clone();
            pop2 = 0;
            dfs2(left);

            if(isAllVisited()){
                System.out.println(Math.abs(pop1-pop2));
                if(Math.abs(pop1-pop2) < minPop) minPop = Math.abs(pop1-pop2);
            }
            visited = tempVisited;
        }
        
        for(int b : arr[a]){
            if(!visited[b]) dfs(b);
        }

        visited[a] = false;
        pop1 -= weight[a];*/
    }

    static void dfs(int a){
        visited[a] = true;
        pop2 += weight[a];

        for(int b : arr[a]){
            if(!visited[b]) dfs(b);
        }
    }
}