import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P27433Factorial2{
    public static long getFactorialOf(long num){
        if(num == 0) return 1;
        if(num == 1) return num;
        else return num * getFactorialOf(num-1);
    }
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 로직
        long result = getFactorialOf(Long.parseLong(br.readLine()));

        // 출력
        bw.write(result + "\n");        

        br.close();
        bw.flush();
        bw.close();
    }
}