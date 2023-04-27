import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1010BuildBridge{
    public static long getCombination(int a, int b){
        long result = 1;
        if(b > a/2) b = a-b;
        for(int i=a, j=0; j<b; i--, j++){
            result *= i;
        }
        
        for(int i=b; i>1; i--){
            result /= i;
        }
        
        return result;
    }
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());

        // Logic
        String[] lines;
        for(int i=0; i<t; i++){
            lines = br.readLine().split(" ");
            int a = Integer.parseInt(lines[0]);
            int b = Integer.parseInt(lines[1]);
            if(a == 0 || b == 0){
                sb.append(0).append("\n");
            }
            else if(a == b){
                sb.append(1).append("\n");
            }
            else if(a > b){
                sb.append(getCombination(a, b)).append("\n");
            }
            else{
                sb.append(getCombination(b, a)).append("\n");
            }
        }

        // Print
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}