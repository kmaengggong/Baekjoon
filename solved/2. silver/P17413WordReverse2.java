import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P17413WordReverse2{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        // Logic
        StringBuilder sbTemp = new StringBuilder();
        int len = line.length();
        boolean isBracket = false;

        for(int i=0; i<len; i++){
            char c = line.charAt(i);
            if(c == '>'){
                sb.append(c);
                isBracket = false;
            }
            else if(c == '<' || isBracket){
                if(sbTemp.length() > 0){
                    sb.append(sbTemp.reverse());
                    sbTemp.delete(0, sbTemp.length());
                }
                sb.append(c);
                isBracket = true;
            }
            else if(c == ' '){
                sb.append(sbTemp.reverse()).append(' ');
                sbTemp.delete(0, sbTemp.length());
            }
            else sbTemp.append(c);
        }

        if(sbTemp.length() > 0){
            sb.append(sbTemp.reverse());
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}