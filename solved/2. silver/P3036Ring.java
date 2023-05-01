import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P3036Ring{
    public static int getGreatestCommonDivisor(int a, int b){
        if(a%b == 0) return b;
        else return getGreatestCommonDivisor(b, a%b);
    }

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] lines = br.readLine().split(" ");
        
        // Logic
        int largestRing = Integer.parseInt(lines[0]);
        for(int i=1; i<n; i++){
            int numerator = Integer.parseInt(lines[i]);
            int gcd = getGreatestCommonDivisor(largestRing, numerator);
            int denominator = largestRing/gcd;
            numerator = numerator/gcd;
            sb.append(denominator).append("/").append(numerator).append("\n");
        }
                
        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}