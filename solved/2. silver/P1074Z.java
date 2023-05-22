import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1074Z{
    public static StringBuffer sb = new StringBuffer();
    public static long count = 0;
    public static int r, c;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // Logic
        z(n, 0, 0);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void z(int len, int x, int y){
        int half = len/2;
        int x1 = x+half;
        int y1 = y+half;
        
        if(len > 1){
            if(x1 <= r){
                if(y1 <= c){
                    count += len*len/4*3;
                    z(half, x1, y1);
                }
                else{
                    count += len*len/2;
                    z(half, x1, y);
                }
            }
            else{
                if(y1 <= c){
                    count += len*len/4;
                    z(half, x, y1);
                }
                else{
                    z(half, x, y);
                }
            }
        }
        else{
            sb.append(count);
            return;
        }
    }
}