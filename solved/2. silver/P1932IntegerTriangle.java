import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1932IntegerTriangle{
    static StringBuffer sb;
    static List<Integer>[] list;
    
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            list[i] = new ArrayList<>();

            for(int j=0; j<=i; j++) list[i].add(Integer.parseInt(st.nextToken()));
        }

        // Logic
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j == 0){
                    list[i].set(j, list[i].get(j)+list[i-1].get(0));
                }
                else if(j == i){
                    list[i].set(j, list[i].get(j)+list[i-1].get(j-1));
                }
                else{
                    int n1 = list[i-1].get(j-1);
                    int n2 = list[i-1].get(j);
                    list[i].set(j, list[i].get(j)+Math.max(n1, n2));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(list[n-1].get(i) > max) max = list[n-1].get(i);
        }

        sb.append(max);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}