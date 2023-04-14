import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2231HarshadNumber{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 메인 로직
        // N = n0 + n1 + n2 ... nn + n0n1n2...nnn 일 때, n0n1n2를 n의 생성자라고 함.
        int result = 0;
        for(int i=1; i<n; i++){
            int number = i;
            int sum = 0;
            while(number/10 > 0){
                sum += number%10;
                number /= 10;
            }
            sum += number;
            sum += i;

            if(sum == n){
                result = i;
                break;
            }
        }

        // 출력 결과
        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}