import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// PQ에 넣고 자동 정렬 후 한 번에 출력 -> 2232ms
// 하나씩 비교하면서 바로 출력 -> 1532ms
// = 비교하는게 더 빠름
public class P11728ArrayMerge{
    static StringBuffer sb;
    
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b;
        int start = 0;

        outer: for(int i=0; i<m; i++){
            b = Integer.parseInt(st.nextToken());
            // Logic
            for(int j=start; j<n; j++){
                if(b > a[j]){
                    sb.append(a[j]).append(" ");
                    start += 1;
                }
                else{
                    sb.append(b).append(" ");
                    start = j;
                    continue outer;
                }
            }
            sb.append(b).append(" ");
        }
        if(start < n){
            for(int i=start; i<n; i++) sb.append(a[i]).append(" ");
        }

        /*PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) pq.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) pq.add(Integer.parseInt(st.nextToken()));

        // Logic
        while(!pq.isEmpty()) sb.append(pq.poll()).append(" ");*/

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}