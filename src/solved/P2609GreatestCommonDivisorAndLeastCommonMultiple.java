import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2609GreatestCommonDivisorAndLeastCommonMultiple{
    public static int getGreatestCommonDivisor(int a, int b){
        if(a%b == 0){
            return b;
        }
        else{
            return getGreatestCommonDivisor(b, a%b);
        }
    }
    public static int getLeastCommonMultiple(int a, int b, int gcd){
        return a * b / gcd;
    }

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String[] lines = br.readLine().split(" ");
        int a = Integer.parseInt(lines[0]);
        int b = Integer.parseInt(lines[1]);
        
        // 로직
        // 유클리드 호재법
        int gcd = 0;

        if(a >= b) gcd = getGreatestCommonDivisor(a, b);
        else gcd = getGreatestCommonDivisor(b, a);

        int lcm = getLeastCommonMultiple(a, b, gcd);

        sb.append(gcd).append("\n").append(lcm);

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}