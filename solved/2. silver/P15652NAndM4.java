import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15652NAndM4{
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
            for(int j=i; j<=n; j++){
                arr[i].add(j);
            }
        }

        for(int i=1; i<=n; i++){
            dfs(i, 1, new StringBuffer());
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int len, StringBuffer sb2){
        StringBuffer sb3 = new StringBuffer(sb2);
        sb3.append(num).append(" ");

        if(len == m){
            sb.append(sb3).append("\n");
        }
        else{
            for(int a : arr[num]){
                dfs(a, len+1, sb3);
            }
        }
    }
}