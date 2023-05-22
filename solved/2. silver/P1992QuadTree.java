import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1992QuadTree{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        char[] lines;
        int[][] video = new int[n][n];

        for(int i=0; i<n; i++){
            lines = br.readLine().toCharArray();
            for(int j=0; j<n; j++) video[i][j] = lines[j] - 48;
        }

        // Logic
        encodeVideo(video, n);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void encodeVideo(int[][] video, int len){
        int newLen = len/2;
        
        if(!checkVideo(video, len)){
            if(newLen < 2){
                sb.append("(");
                for(int i=0; i<len; i++){
                    for(int j=0; j<len; j++){
                        sb.append(video[i][j]);
                    }
                }
                sb.append(")");
    
                return;
            }

            sb.append("(");
            
            int[][] video1 = new int[newLen][newLen];
            int[][] video2 = new int[newLen][newLen];
            int[][] video3 = new int[newLen][newLen];
            int[][] video4 = new int[newLen][newLen];

            for(int i=0; i<newLen; i++){
                System.arraycopy(video[i], 0, video1[i], 0, newLen);
                System.arraycopy(video[i], newLen, video2[i], 0, newLen);
                System.arraycopy(video[i+newLen], 0, video3[i], 0, newLen);
                System.arraycopy(video[i+newLen], newLen, video4[i], 0, newLen);
            }

            encodeVideo(video1, newLen);
            encodeVideo(video2, newLen);
            encodeVideo(video3, newLen);
            encodeVideo(video4, newLen);

            sb.append(")");
        }
    }

    public static boolean checkVideo(int[][] video, int len){
        boolean isPerfect = true;
        int number;

        if(video[0][0] == 1) number = 1;
        else number = 0;

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(video[i][j] != number){
                    isPerfect = false;
                    break;
                }
            }
        }

        if(isPerfect){
            sb.append(number);
        }

        return isPerfect;
    }
}