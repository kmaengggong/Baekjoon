import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15650NAndM2{
    public static StringBuffer sb = new StringBuffer();
    public static ArrayList<Integer>[] arr;
    public static int n, m;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // Logic
        arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<Integer>();
            for(int j=i+1; j<=n; j++){
                arr[i].add(j);
            }
        }

        for(int i=1; i<=n; i++){
            boolean[] visited = new boolean[n+1];
            dfs(i, 1, visited);
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int len, boolean[] visit){
        boolean[] newVisit = new boolean[n+1];
        System.arraycopy(visit, 0, newVisit, 0, n+1);
        newVisit[num] = true;

        if(len == m){
            for(int i=1; i<=n; i++){
                if(newVisit[i]) sb.append(i).append(" ");
                
            }
            sb.append("\n");
        }
        else{
            for(int a : arr[num]){
                if(newVisit[a]) continue;
                dfs(a, len+1, newVisit);
            }
        }
    }
}