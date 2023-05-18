import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2630ColoredPaperMake{
    public static StringBuffer sb = new StringBuffer();
    public static int whiteCount = 0;
    public static int blueCount = 0;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        boolean[][] papers = new boolean[n][n];

        StringTokenizer st;
        int input;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                input = Integer.parseInt(st.nextToken());
                if(input == 1) papers[i][j] = true;
                else papers[i][j] = false;
            }
        }

        // Logic
        if(!isAllWhiteOrBlue(papers)){
            Queue<boolean[][]> queue = new LinkedList<>();
            queue.add(papers);

            while(!queue.isEmpty()){
                boolean[][] paper = queue.poll();
                int len = paper[0].length;
                int half = len/2;

                if(len == 1){
                    if(paper[0][0]) blueCount += 1;
                    else whiteCount += 1;
                    continue;
                }
    
                // System.arraycopy 보다 이게 더 빠를 거 같음
                boolean[][] paper1 = new boolean[half][half];
                boolean[][] paper2 = new boolean[half][half];
                boolean[][] paper3 = new boolean[half][half];
                boolean[][] paper4 = new boolean[half][half];

                for(int i=0; i<half; i++){
                    for(int j=0; j<half; j++){
                        paper1[i][j] = paper[i][j];
                        paper2[i][j] = paper[i+half][j];
                        paper3[i][j] = paper[i][j+half];
                        paper4[i][j] = paper[i+half][j+half];
                    }
                }

                if(!isAllWhiteOrBlue(paper1)) queue.add(paper1);
                if(!isAllWhiteOrBlue(paper2)) queue.add(paper2);
                if(!isAllWhiteOrBlue(paper3)) queue.add(paper3);
                if(!isAllWhiteOrBlue(paper4)) queue.add(paper4);
            }

        }
        
        sb.append(whiteCount).append("\n").append(blueCount);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isAllWhiteOrBlue(boolean[][] papers){
        boolean isAllWOB = true;
        int len = papers[0].length;

        if(papers[0][0]){
            blueCount += 1;
            outer: for(int i=0; i<len; i++){
                for(int j=0; j<len; j++){
                    if(!papers[i][j]){
                        blueCount -= 1;
                        isAllWOB = false;
                        break outer;
                    }
                }
            }
        }
        else{
            whiteCount += 1;
            outer: for(int i=0; i<len; i++){
                for(int j=0; j<len; j++){
                    if(papers[i][j]){
                        whiteCount -= 1;
                        isAllWOB = false;
                        break outer;
                    }
                }
            }
        }

        return isAllWOB;
    }
}