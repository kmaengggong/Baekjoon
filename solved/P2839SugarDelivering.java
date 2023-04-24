import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2839SugarDelivering{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 로직
        StringBuilder sb = new StringBuilder();
        int left = n;
        int bag = 0;
        boolean isBag = false;

        while(left >= 5){
            bag += 1;
            left -= 5;
        }
        while(left >= 3){
            bag += 1;
            left -= 3;
        }
        if(left == 0) isBag = true;
        if(left == 1 || left == 2){
            if(n > 5){
                while(left+5 <= n){
                    left += 5;
                    bag -= 1;
                    if(left%3 == 0){
                        bag += left/3;
                        left %= 3;
                        isBag = true;
                        break;
                    }
                }
            }
            else bag = -1;
        }
        if(!isBag) bag = -1;

        sb.append(bag).append("\n");

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}