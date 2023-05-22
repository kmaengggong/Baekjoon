import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P11279MaximumHeap{
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Comparator<Integer> com = new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(o1 > o2) return -1;
                else if(o1 < o2) return 1;
                else return 0;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(com);

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
            else{
                pq.add(num);
            }
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}