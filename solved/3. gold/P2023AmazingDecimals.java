import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2023AmazingDecimals{
    public static StringBuffer sb = new StringBuffer();
    public static int n;
    public static int[] decimals = {2, 3, 5, 7};
    public static int[] odds = {1, 3, 5, 7, 9};

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        // Logic
        if(n == 1){
            for(int i : decimals){
                sb.append(i).append("\n");
            }
        }
        else{
            for(int i : decimals){
                dfs(i, 1);
            }
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int len){
        if(len == n){
            if(isDecimal(num)) sb.append(num).append("\n");
        }
        else{
            for(int i : odds){
                if(isDecimal(num*10 + i)) dfs(num*10 + i, len+1);
            }
        }
    }

    public static boolean isDecimal(int num){
        int len = num/2;
        for(int i=2; i<len; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}