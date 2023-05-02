import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.TreeSet;

public class P1015SequenceSort{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] lines = br.readLine().split(" ");

        // Logic
        HashSet<Integer> hashSeqs = new HashSet<>();
        int[] inputs = new int[n];
        int seq;
        for(int i=0; i<n; i++){
            seq = Integer.parseInt(lines[i]);
            hashSeqs.add(seq);
            inputs[i] = seq;
        }

        TreeSet<Integer> seqs = new TreeSet<>();
        seqs.addAll(hashSeqs);

        int[] results = new int[n];
        int result = 0;
        for(int num : seqs){
            int idx = 0;
            for(int i=0; i<n; i++){
                if(inputs[i] == num){
                    idx = i;
                    inputs[idx] = 0;
                    results[idx] = result;
                    result += 1;
                }
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