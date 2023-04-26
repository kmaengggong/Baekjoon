import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P19532MathIsOnlineLecture{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line[] = br.readLine().split(" ");

        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);
        int d = Integer.parseInt(line[3]);
        int e = Integer.parseInt(line[4]);
        int f = Integer.parseInt(line[5]);

        // 메인 로직
        // (bd - ae)x = bf - ec;
        // y = (c-ax)/b
        // a, b / d, e가 동시에 0일 수 없음
        // 동시에 0이면 xy값이 유일하지 않음.
        int x = 0;
        int y = 0;

        int bdae = b*d - a*e;
        int bfec = b*f - e*c;

        if(a == 0){
            y = c/b;
            x = (f-e*y)/d;
        }
        else if(b == 0){
            x = c/a;
            y = (f-d*x)/e;
        }
        else if(d == 0){
            y = f/d;
            x = (c-b*y)/a;
        }
        else if(e == 0){
            x = f/e;
            y = (c-x*y)/b;
        }
        else{
            for(int i=-999; i<=999; i++){
                if((bdae * i) == bfec){
                    x = i;
                    break;
                }
            }
            y = (c - a*x)/b;
        }

        // 출력 결과
        bw.write(x + " " + y);

        br.close();
        bw.flush();
        bw.close();
    }
}