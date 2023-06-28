import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static StringBuffer sb;
    static boolean[][] gears;
    static int[] scores = {1, 2, 4, 8};

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        gears = new boolean[4][8];

        for(int i=0; i<4; i++){
            char[] input = br.readLine().toCharArray();

            for(int j=0; j<8; j++){
                if(input[j] == '0') gears[i][j] = false;
                else gears[i][j] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken())-1;
            boolean dir;
            if(Integer.parseInt(st.nextToken()) == 1) dir = true;
            else dir = false;

            // Logic
            spinGears(idx, dir);
            if(idx > 0) selectLeft(idx, dir);
            if(idx < 3) selectRight(idx, dir);
        }

        sb.append(getScore());

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void spinGears(int idx, boolean dir){
        if(dir){
            boolean temp = gears[idx][7];
            for(int i=7; i>0; i--){
                gears[idx][i] = gears[idx][i-1];
            }
            gears[idx][0] = temp;
        }
        else{
            boolean temp = gears[idx][0];
            for(int i=0; i<7; i++){
                gears[idx][i] = gears[idx][i+1];
            }
            gears[idx][7] = temp;
        }
    }

    static void selectLeft(int idx, boolean dir){
        int alpha = 5;
        if(dir) alpha = 7;
        if(idx > 0 && gears[idx-1][2] != gears[idx][alpha]){
            spinGears(idx-1, !dir);
            selectLeft(idx-1, !dir);
        }
    }
    static void selectRight(int idx, boolean dir){
        int alpha = 1;
        if(dir) alpha = 3;
        if(idx < 3 && gears[idx+1][6] != gears[idx][alpha]){
            spinGears(idx+1, !dir);
            selectRight(idx+1, !dir);
        }
    }

    static int getScore(){
        int result = 0;
        for(int i=0; i<4; i++){
            if(gears[i][0]) result += scores[i]; 
        }
        return result;
    }
}