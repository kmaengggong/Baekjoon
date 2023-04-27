import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class P2217Rope{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // Logic
        HashMap<Integer, Integer> ropes = new HashMap<>();
        int rope;
        for(int i=0; i<n; i++){
            rope = Integer.parseInt(br.readLine());
            if(ropes.containsKey(rope)){
                ropes.put(rope, ropes.get(rope)+1);
            }
            else ropes.put(rope, 1);
        }
        
        TreeSet<Integer> oneRopes = new TreeSet<>();
        oneRopes.addAll(ropes.keySet());

        int max = 0;
        int sum = 0;
        for(int r : oneRopes){
            sum = r*n;
            if(sum > max) max = sum;
            n -= ropes.get(r);
        }

        sb.append(max);

        // Print
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}