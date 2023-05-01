import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P11656Suffix{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        // Logic
        if(s.length() == 0){
            sb.append("\n");
        }
        else{
            int len = s.length();
            String[] words = new String[len];
            words[0] = s;
            for(int i=1; i<len; i++){
                words[i] = s.substring(i, len);
            }

            Arrays.sort(words);

            for(int i=0; i<len; i++){
                sb.append(words[i]).append("\n");
            }
        }
        
        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}