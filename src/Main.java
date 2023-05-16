import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = br.read()-96;
        }

        // 로직
        // 예제 1: abcde의 해시 값은 1 × 310 + 2 × 311 + 3 × 312 + 4 × 313 + 5 × 314 = 1 + 62 + 2883 + 119164 + 4617605 = 4739715이다.
        // L <= 50이기 때문에, 31^50 이면 어쩌라는겨

        //int hash = 0;
        BigInteger bi = new BigInteger("0");
        for(int i=0; i<n; i++){
            //hash += numbers[i] * Math.pow(31, i);
            BigInteger sum = new BigInteger("31");
            sum = sum.pow(i);
            sum = sum.multiply(new BigInteger(Integer.toString(numbers[i])));
            System.out.println(sum);

            bi = bi.add(sum);
        }
        sb.append(bi).append("\n");

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}