import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static StringBuffer sb;
    static boolean[][] gears = new boolean[4][8];
    static int k;
    static int[] score = {1, 2, 4, 8};

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();
    
        for(int i=0; i<4; i++){
            char[] input = br.readLine().toCharArray();
            for(int j=0; j<8; j++){
                if(input[j] == '1') gears[i][j] = true;
            }
        }

        k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        showGears();
        
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());

            int gearNumber = Integer.parseInt(st.nextToken())-1;
            boolean spinDirection;
            if(Integer.parseInt(st.nextToken()) == 1) spinDirection = true;
            else spinDirection = false;

            // Logic
            spinGear(gearNumber, spinDirection);
            if(gearNumber > 0) spinLeftGear(gearNumber, spinDirection);
            if(gearNumber < 3) spinRightGear(gearNumber, spinDirection);
        }

        sb.append(getScore());

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void showGears(){
        for(int i=0; i<4; i++){
            for(int j=0; j<8; j++){
                if(gears[i][j]) System.out.print("1");
                else System.out.print("0");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void spinGear(int gNum, boolean sDir){
        if(sDir){
            boolean temp = gears[gNum][7];
            for(int i=6; i>0; i--){
                gears[gNum][i] = gears[gNum][i-1];
            }
            gears[gNum][0] = temp;
        }
        else{
            boolean temp = gears[gNum][0];
            for(int i=0; i<7; i++){
                gears[gNum][i] = gears[gNum][i+1];
            }
            gears[gNum][7] = temp;
        }
        showGears();
    }

    static void spinLeftGear(int gNum, boolean sDir){

        int dir = 0;
        if(sDir) dir = 7;
        else dir = 5;
        //spinGear(gNum, sDir);
        if(gNum > 0 && gears[gNum][dir] != gears[gNum-1][2]){
                            System.out.println("L");
            spinGear(gNum-1, !sDir);
            spinLeftGear(gNum-1, !sDir);
        }

    }

    static void spinRightGear(int gNum, boolean sDir){

        int dir = 0;
        if(sDir) dir = 3;
        else dir = 1;
        //spinGear(gNum, sDir);
        if(gNum < 3 && gears[gNum][dir] != gears[gNum+1][6]){
                    System.out.println("R");
            spinGear(gNum+1, !sDir);
            spinRightGear(gNum+1, !sDir);
        }
    }

    static int getScore(){
        int result = 0;

        for(int i=0; i<4; i++){
            if(gears[i][0]){
                result += score[i];
            }
        }

        return result;
    }
}