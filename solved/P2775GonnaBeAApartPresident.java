import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2775GonnaBeAApartPresident{
    public static int getPeople(int floor, int room){
        if(room == 1) return 1;
        if(floor == 0) return room;
        else{
            return getPeople(floor-1, room) + getPeople(floor, room-1);
        }
    }
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        // 로직
        int k;  // k층
        int n;  // n호
        for(int i=0; i<t; i++){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            sb.append(getPeople(k, n)).append("\n");
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}