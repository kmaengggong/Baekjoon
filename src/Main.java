import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        String[] lines;
        String[] lines2;
        Deque<Integer> deque = new LinkedList<>();
        
        for(int i=0; i<t; i++){
            lines = br.readLine().split(" ");
            lines2 = br.readLine().split(" ");
            int n = Integer.parseInt(lines[0]);
            int m = Integer.parseInt(lines[1]);
            int doc = Integer.parseInt(lines2[0]);
            deque.add(doc);
            for(int j=1; j<n; j++){
                doc = Integer.parseInt(lines2[j]);
                if(deque.getLast() < doc){
                    deque.addFirst(doc);
                }
                else{
                    deque.addLast(doc);
                }
            }
            for(int j=0; j<n; j++){
                deque.peekFirst();
                if(j == m) sb.append(deque.peekFirst()).append("\n");
            }
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}