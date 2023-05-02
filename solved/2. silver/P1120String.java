import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1120String{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] lines = br.readLine().split(" ");
        String a = lines[0];
        String b = lines[1];

        // Logic
        int aLength = a.length();
        int bLength = b.length();
        int lenDiff = bLength-aLength;
        int maxSame = Integer.MIN_VALUE;

        for(int i=0; i<=lenDiff; i++){
            int same = 0;
            for(int j=0, k=i; j<aLength; j++, k++){
                if(b.charAt(k) == a.charAt(j)) same += 1; 
            }

            if(same > maxSame) maxSame = same;
        }
        sb.append(aLength-maxSame);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}