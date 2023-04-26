import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10870Fibonacci5{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // Logic
        int[] fibonacci = new int[]{
            0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
            89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765
        };
        sb.append(fibonacci[Integer.parseInt(br.readLine())]);

        // Print
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}