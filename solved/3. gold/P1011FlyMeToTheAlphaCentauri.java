import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1011FlyMeToTheAlphaCentauri{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();
        
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // Logic
            int num = e-s;
            int n = 0;

            while(num > 0){
                n += 1;
                num -= n*2;
            }
            if(num == 0){
                sb.append(n*2);
            }
            else{
                num += n*2;
                n -= 1;
                if(num < n+2){
                    sb.append(n*2+1);
                }
                else{
                    sb.append(n*2+2);
                }
            }
            sb.append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}