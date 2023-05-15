import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15649NAndM1{
    public static StringBuffer sb = new StringBuffer();
    public static int n, m;
    public static ArrayList<Integer>[] numbers;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); 
        numbers = new ArrayList[n+1];   

        // Logic
        for(int i=1; i<=n; i++){
            numbers[i] = new ArrayList<>();
            for(int j=1; j<=n; j++){
                if(i != j) numbers[i].add(j);
            }
        }

        for(int i=1; i<=n; i++){
            boolean[] visited = new boolean[n+1];
            dfs(i, 1, visited, new StringBuffer());
        }

        // Output
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int len, boolean[] visited, StringBuffer buffer){
        boolean[] copiedVisited = new boolean[n+1];
        System.arraycopy(visited, 0, copiedVisited, 0, n+1);
        StringBuffer copiedBuffer = new StringBuffer(buffer.toString());

        if(len >= m){
            copiedBuffer.append(num).append("\n");
            sb.append(copiedBuffer);
            return;
        }
        else{
            copiedBuffer.append(num).append(" ");
            for(int number : numbers[num]){
                if(!copiedVisited[number]){
                    copiedVisited[num] = true;
                    dfs(number, len+1, copiedVisited, copiedBuffer);
                }
            }
        }
    }
}