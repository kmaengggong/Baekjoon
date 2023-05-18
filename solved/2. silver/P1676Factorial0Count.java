import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1676Factorial0Count{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // Logic
        int fiveCount = 0;

        if(n == 0) sb.append(0);
        else{
            for(int i=1; i<=n; i++){
                int num = i;
                if(i%5 == 0){
                    while(num%5 == 0){
                        num /= 5;
                        fiveCount += 1;
                    }
                } 
            }
            sb.append(fiveCount);
        }



        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}