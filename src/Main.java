import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] lines = br.readLine().split(" ");

        // Logic
        HashMap<Integer, Integer> seqs = new HashMap<>();
        //ArrayList<Integer> inputs = new ArrayList<>();
        int[] inputs = new int[n];
        int seq;
        for(int i=0; i<n; i++){
            seq = Integer.parseInt(lines[i]);
            if(seqs.containsKey(seq)){
                seqs.put(seq, seqs.get(seq)+1);
            }
            else seqs.put(seq, 1);
            //inputs.add(seq);
            inputs[i] = seq;
        }

        //ArrayList<Integer> results = new ArrayList<>(n);
        int[] results = new int[n];
        int result = 0;
        for(int num : seqs.keySet()){
            int left = seqs.get(num);
            while(left > 0){
                //int idx = inputs.indexOf(num);
                int idx = 0;
                for(int i=0; i<n; i++){
                    if(inputs[i] == num) idx = i;
                }
                inputs[idx] = 0;
                //results.add(idx, result);
                results[idx] = result;
                result += 1;
                seqs.put(num, left-1);
                left = seqs.get(num);
            }
        }
        for(int r : results) sb.append(r).append(" ");

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}