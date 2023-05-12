import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class P1158JosephusProblem {
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);

        // Logic
        Queue<Integer> circle = new LinkedList<>();
        for(int i=1; i<=n; i++) circle.add(i);
        
        sb.append("<");

        for(int i=0; i<n; i++){
            for(int j=0; j<k-1; j++) circle.add(circle.poll());

            sb.append(circle.poll()).append(", ");
        }
        
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}