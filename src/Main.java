import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static int getCommonFactor(int a, int b){
        if(a % b == 0){
            return b;
        }
        else{
            return getCommonFactor(b, a%b);
        }
    }
    public static void main(String[] args) throws IOException {
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        String line = br.readLine();
        int a1 = Integer.parseInt(line.split(" ")[0]);
        int b1 = Integer.parseInt(line.split(" ")[1]);
        line = br.readLine();
        int a2 = Integer.parseInt(line.split(" ")[0]);
        int b2 = Integer.parseInt(line.split(" ")[1]);

        // 메인 로직
        // 1. 분수끼리 덧셈
        // 2. 걍 통분 후에 최대공약수로 나누면 됨...
        int a;
        int b;

        b = b1 * b2;
        a = (a1*b2) + (a2*b1);

        int cFactor = getCommonFactor(a, b);

        // 결과 출력
        bw.write(a/cFactor + " " + b/cFactor);

        br.close();
        bw.flush();
        bw.close();
    }
}