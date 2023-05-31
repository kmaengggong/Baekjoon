import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2003NumbersSum2{
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int sum = 0;
        int count = 0;
        int start = 0;

        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
            if(sum == m){
                count += 1;
                sum -= a[start];
                start += 1;
            }
            else if(sum > m){
                while(sum > m){
                    sum -= a[start];
                    start += 1;
                }
                if(sum == m){
                    count += 1;
                    sum -= a[start];
                    start += 1;
                }
            }
        }

        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
;    }
}