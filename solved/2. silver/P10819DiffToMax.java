import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10819DiffToMax{
    static StringBuffer sb;
    static int n, sum, result;
    static int[] numbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());
        
        numbers = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        // Logic
        result = 0;

        for(int i=0; i<n; i++){
            sum = 0;
            dfs(i, numbers[i]);
        }

        sb.append(result);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int numberx){
        visited[x] = true;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                sum += Math.abs(numberx - numbers[i]);
                if(sum > result) result = sum;
                dfs(i, numbers[i]);
                sum -= Math.abs(numberx - numbers[i]);

            }
        }
        visited[x] = false;
    }
}