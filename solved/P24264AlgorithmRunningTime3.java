import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P24264AlgorithmRunningTime3{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        
        // 로직
        long count = n*n;

        // 출력
        bw.write(count + "\n" + 2);

        br.close();
        bw.flush();
        bw.close();
    }
}