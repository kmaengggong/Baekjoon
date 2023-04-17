import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P24267AlgorithmRunningTime6{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        
        // 로직
        long count = 0;
        for(long i=1; i<=n-2; i++){
            count += i*(n-1-i);
        }

        // 출력
        bw.write(count + "\n" + 3);

        br.close();
        bw.flush();
        bw.close();
    }
}