import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1654LanCutting{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] lans = new long[n];

        for(int i=0; i<n; i++) lans[i] = Integer.parseInt(br.readLine());

        // Logic
        // 범위가 1~Integer.MAX_VALUE인데, end를 그냥 MAX_VALUE로 하면
        // MAX_VALUE가 답일 때, start가 절대 그 값에 도달할 수 없음
        long start = 1;
        long end = (long)Integer.MAX_VALUE+1;

        while(start+1 < end){
            long mid = (start+end)/2;
            long sum = 0;

            for(int i=0; i<n; i++){
                sum += lans[i]/mid;
            }

            if(sum >= m) start = mid;
            else end = mid;
        }
        
        sb.append(start);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}