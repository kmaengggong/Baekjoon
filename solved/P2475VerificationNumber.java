import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2475VerificationNumber{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 로직
        String[] lines = br.readLine().split(" ");
        
        final int n = 5;
        final int div = 10;
        int sum = 0;
        int num;
        for(int i=0; i<n; i++){
            num = Integer.parseInt(lines[i]);
            sum += num*num;
        }
        sb.append(sum%div);

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}