import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // Logic
        int limit = (int)Math.pow(10, n);
        int[] che = new int[limit];
        LinkedHashSet<Integer> decimals = new LinkedHashSet<>();
        for(int i=2; i<limit; i++){
            if(che[i] == 0){
                decimals.add(i);
                for(int j=i; j<limit; j+=i) che[j] = 1;
            }
        }
        che = null;

        limit /= 10;
        boolean isAmazing;
        for(int decimal : decimals){
            isAmazing = true;
            int temp = decimal;
            if(temp >= limit){
                while(temp > 0){
                    if(!decimals.contains(temp)){
                        isAmazing = false;
                        break;
                    }
                    temp /= 10;
                }
                if(isAmazing) sb.append(decimal).append("\n");
            }
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}