import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;

public class P2331RepeatedSequence{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] lines = br.readLine().split(" ");
        int a = Integer.parseInt(lines[0]);
        int p = Integer.parseInt(lines[1]);

        // Logic
        LinkedHashSet<Integer> seqs = new LinkedHashSet<>();
        seqs.add(a);
        while(true){
            String num = Integer.toString(a);
            int len = num.length();
            int sum = 0;
            for(int i=0; i<len; i++){
                int oneNum = num.charAt(i)-48;
                sum += Math.pow(oneNum, p);
            }
            if(seqs.contains(sum)){
                a = sum;
                break;
            }
            else seqs.add(sum);
            a = sum;
        }

        int count = 0;
        for(int seq : seqs){
            if(seq == a) break;
            count += 1;
        }
        sb.append(count).append("\n");

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}