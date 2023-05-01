import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class P2776MemorizationKing{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        // Logic
        for(int i=0; i<t; i++){
            String[] lines;
            
            int n = Integer.parseInt(br.readLine());
            lines = br.readLine().split(" ");
            HashSet<Integer> note1 = new HashSet<>();
            for(int j=0; j<n; j++){
                note1.add(Integer.parseInt(lines[j]));
            }

            int m = Integer.parseInt(br.readLine());
            lines = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                if(note1.contains(Integer.parseInt(lines[j]))) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}