import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P10610_30{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        char[] input = br.readLine().toCharArray();
        
        int len = input.length;
        int[] intInput = new int[len];
        
        for(int i=0; i<len; i++) intInput[i] = input[i]-48;

        // Logic
        Arrays.sort(intInput);

        boolean isThirty = true;
        if(intInput[0] != 0) isThirty = false;
        else{
            int check = 0;
            for(int i=len-1; i>0; i--){
                check = ((check*10) + intInput[i]%3)%3;
                if(check%3 == 0) check = 0;
                sb.append(intInput[i]);
            }
            if(check != 0) isThirty = false;
        }

        if(isThirty) sb.append(intInput[0]);
        else{
            sb.delete(0, sb.length());
            sb.append("-1");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}