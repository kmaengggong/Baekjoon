import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2018NumbersSum5{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // Logic
        int count = 0;
        int sum;
        for(int i=1; i<=n; i++){
            sum = 0;
            for(int j=i; j<=n; j++){
                sum += j;
                if(sum == n){
                    count += 1;
                    break;
                }
                else if(sum > n) break;
            }
        }
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

/* 정답코드: 232ms -> 180ms
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // Logic
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        while(endIndex < n){
            if(sum == n){
                count += 1;
                endIndex += 1;
                sum += endIndex;
            }
            else if(sum > n){
                sum -= startIndex;
                startIndex += 1;
            }
            else{
                endIndex += 1;
                sum += endIndex;
            }
        }
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */