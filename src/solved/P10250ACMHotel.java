import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10250ACMHotel{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        // 로직
        String lines[];
        for(int i=0; i<t; i++){
            lines = br.readLine().split(" ");
            int h = Integer.parseInt(lines[0]);  // 호텔 층수
            int w = Integer.parseInt(lines[1]);  // 호텔 층별 방 갯수
            int n = Integer.parseInt(lines[2]);  // n번째 손님

            if(h >= n) sb.append(n).append(0).append(1);
            else{
                int floors = n-h;
                int rooms = 2;
                while(floors > h){
                    floors -= h;
                    rooms += 1;
                }
                sb.append(floors);
                if(rooms < 10) sb.append(0).append(rooms);
                else sb.append(rooms);
            }
            sb.append("\n");
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}