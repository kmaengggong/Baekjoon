import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P1021SpinningQueue{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int m = Integer.parseInt(lines[1]);

        // Logic
        Deque<Integer> deque = new LinkedList<>();
        for(int i=1; i<=n; i++) deque.add(i);

        lines = br.readLine().split(" ");
        int count = 0;
        for(int i=0; i<m; i++){
            int len = deque.size();
            int find = Integer.parseInt(lines[i]);
            if(deque.getFirst() == find){
                deque.pollFirst();
            }
            else{
                // 왼쪽 거리 구하기
                int left = 0;
                for(int deq : deque){
                    if(deq == find){
                        break;
                    }
                    left += 1;
                }
                int right = len-left-1;
                
                // 왼쪽이 더 짧거나 같으면 왼쪽으로 회전
                if(left <= right){
                    while(deque.getFirst() != find){
                        deque.addLast(deque.pollFirst());
                        count += 1;
                    }
                }
                else{
                    while(deque.getFirst() != find){
                        deque.addFirst(deque.pollLast());
                        count += 1;
                    }
                }
                deque.pollFirst();
            }
        }
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}