import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P17219PasswordFind{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> hMap = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            hMap.put(st.nextToken(), st.nextToken());
        }

        for(int i=0; i<m; i++){
            sb.append(hMap.get(br.readLine())).append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}