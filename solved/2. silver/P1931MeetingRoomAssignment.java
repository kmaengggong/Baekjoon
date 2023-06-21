import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1931MeetingRoomAssignment{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Comparator<int[]> com = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    if(o1[0] == o2[0]) return 0;
                    else if(o1[0] > o2[0]) return -1;
                    else return 1; 
                }
                else if(o1[1] > o2[1]) return -1;
                else return 1;
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(com);

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // Logic
        Stack<int[]> stack = new Stack<>();
        stack.add(pq.poll());

        //for(int[] i : pq) System.out.println(i[0] + ", " + i[1]);
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            if(now[1] <= stack.peek()[1]){
                if(now[1] <= stack.peek()[0]){
                    stack.push(now);
                }
                else if(now[0] > stack.peek()[0]){
                    stack.pop();
                    stack.add(now);
                }
            }
        }
        //for(int[] i : stack) System.out.println(i[0] + ", " + i[1]);
        sb.append(stack.size());

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}