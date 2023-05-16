import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1966PrinterQueue{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        // Logic
        StringTokenizer st;
        Queue<Integer[]> queue = new LinkedList<>();
        int n, m;

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                queue.add(new Integer[]{j, Integer.parseInt(st.nextToken())});
            }

            Integer[] now = new Integer[2];
            int count = 0;
            while(!queue.isEmpty()){
                now = queue.poll();
                
                Iterator<Integer[]> itr = queue.iterator();
                int que;
                boolean isPrint = true;

                while(itr.hasNext()){
                    que = itr.next()[1];
                    if(que > now[1]){
                        queue.add(now);
                        isPrint = false;
                        break;
                    }
                }
                
                if(isPrint){
                    count += 1;
                    if(now[0] == m){
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
            queue.clear();
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}