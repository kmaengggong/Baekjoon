import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1463Make1{
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        // Logic
        int[] table = new int[n+3];
        table[1] = 0;
        table[2] = 1;
        table[3] = 1;
        int min, now;
        for(int i=4; i<=n; i++){
            min = Integer.MAX_VALUE;
            if(i%3 == 0){
                now = table[i/3] + 1;
                if(now < min) min = now;
            }
            if(i%2 == 0){
                now = table[i/2] + 1;
                if(now < min) min = now;
            }
            now = table[i-1] + 1;
            if(now < min) min = now;
            now = table[i-2] + 2;
            if(now < min) min = now;
            table[i] = min;
        }
        sb.append(table[n]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

/* 정답코드: 148ms -> 144ms
// 1. table[i-2] + 2 비교 불필요
// 2. 아마 table 계속 탐색하는 거랑 Math 쓰는 것보다
// int에 저장하고 if 비교가 더 빠르지 않을까 싶음
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        // Logic
        int[] table = new int[n+1];
        table[1] = 0;
        for(int i=2; i<=n; i++){
            table[i] = table[i-1] + 1;
            if(i%2 == 0) table[i] = Math.min(table[i], table[i/2]+1);
            if(i%3 == 0) table[i] = Math.min(table[i], table[i/3]+1);
        }
        sb.append(table[n]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */