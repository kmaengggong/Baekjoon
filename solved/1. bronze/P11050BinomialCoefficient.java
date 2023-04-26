import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P11050BinomialCoefficient{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);
        
        // 로직
        // 이항계수가 먼지 잘 모르겠는데 {n / k } = nCk라고 하니
        int result = 1;
        for(int i=n; i>n-k; i--){
            result *= i;
        }
        for(int i=1; i<=k; i++){
            result /= i;
        }
        sb.append(result).append("\n");

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}