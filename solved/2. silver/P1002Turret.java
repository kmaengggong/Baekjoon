import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1002Turret{
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
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // Logic
            double distance = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));

            int r3 = r1+r2;

            // 두 원의 중심좌표가 같음
            if(x1 == x2 && y1 == y2){
                // 두 원이 완전히 일치
                if(r1 == r2) sb.append("-1");
                // 한 원이 다른 원 안에 있음
                else sb.append("0");
            }
            // 두 원이 외접
            else if(distance == r3) sb.append("1");
            else if(distance < r3){
                // 한 원이 다른 원 안에 있음
                if(distance+r1 < r2 || distance+r2 < r1) sb.append(0);
                // 두 원이 내접
                else if(distance+r1 == r2 || distance+r2 == r1) sb.append(1);
                // 두 원이 교접
                else sb.append("2");
            }
            // 두 원이 밖에서 만나지 않음
            else sb.append("0");

            sb.append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}