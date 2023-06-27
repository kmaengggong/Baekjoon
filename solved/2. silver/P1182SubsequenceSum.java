import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1182SubsequenceSum{
    static StringBuffer sb;
    static int n, s, count;
    static int[] input;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) input[i] = Integer.parseInt(st.nextToken());

        // Logic
        count = 0;
        for(int i=0; i<n; i++){
            visited[i] = true;
            dfs(i, input[i]);
        }

        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int sum){
        if(sum == s) count += 1;

        for(int i=x; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, sum+input[i]);
                visited[i] = false;
            }
        }
    }
}