import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1389KevinBacons6StepsRules{
    static StringBuffer sb;
    static int n, m;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];

        for(int i=1; i<=n; i++) arr[i] = new ArrayList<Integer>();
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        // Logic
        Comparator<Kevin> com = new Comparator<>(){
            @Override
            public int compare(Kevin o1, Kevin o2){
                if(o1.kevin > o2.kevin) return 1;
                else if(o1.kevin < o2.kevin) return -1;
                else{
                    if(o1.number > o2.number) return 1;
                    else if(o1.number < o2.number) return -1;
                    else return 0;
                }
            }
        };

        PriorityQueue<Kevin> pq = new PriorityQueue<>(com);

        for(int i=1; i<=n; i++){
            int count = 0;

            for(int j=1; j<=n; j++){
                if(i == j) continue;
                int target = j;

                Queue<Integer> queue = new LinkedList<>();
                Queue<Integer> queue2 = new LinkedList<>();
                queue.add(i);
                boolean isValid = false;
                boolean[] visited = new boolean[n+1];
                visited[i] = true;

                while(!queue.isEmpty() || !queue2.isEmpty()){
                    while(!queue.isEmpty()){
                        int now = queue.poll();
                        for(int ar : arr[now]){
                            if(!visited[ar]){
                                visited[ar] = true;
                                if(ar == target){
                                    isValid = true;
                                    break;
                                }
                                queue2.add(ar);
                            }
                        }
                    }
                    count += 1;
                    if(isValid) break;
                    while(!queue2.isEmpty()){
                        int now = queue2.poll();
                        for(int ar : arr[now]){
                            if(!visited[ar]){
                                visited[ar] = true;
                                if(ar == target){
                                    isValid = true;
                                    break;
                                }
                                queue.add(ar);
                            }
                        }
                    }
                    count += 1;
                    if(isValid) break;
                }
            }

            pq.add(new Kevin(i, count));
        }

        sb.append(pq.poll().number);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

class Kevin{
    int number;
    int kevin;

    public Kevin(int number, int kevin){
        this.number = number;
        this.kevin = kevin;
    }
}