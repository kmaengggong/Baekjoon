import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class P1026Tressure{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());

        // Logic
        // B[]를 정렬하면 안됨 -> 그냥 할거임
        Integer[] as = new Integer[n];
        int[] bs = new int[n];
        String[] linesA = br.readLine().split(" ");
        String[] linesB = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            as[i] = Integer.parseInt(linesA[i]);
            bs[i] = Integer.parseInt(linesB[i]);
        }

        Arrays.sort(as, Collections.reverseOrder());
        Arrays.sort(bs);        

        int result = 0;
        for(int i=0; i<n; i++){
            result += as[i]*bs[i];
        }
        sb.append(result);

        // Print
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}