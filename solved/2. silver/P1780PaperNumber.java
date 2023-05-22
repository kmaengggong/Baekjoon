import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1780PaperNumber{
    public static StringBuffer sb = new StringBuffer();
    public static int oneCount = 0;
    public static int zeroCount = 0;
    public static int mOneCount = 0;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] papers = new int[n][n];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Logic
        cutPaper(papers);

        sb.append(mOneCount).append("\n").append(zeroCount).append("\n").append(oneCount);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void cutPaper(int[][] paper){
        int len = paper[0].length;
        int newLen = len/3;
        int newNewLen = newLen*2;

        if(!checkPaper(paper)){
            int[][] paper1 = new int[newLen][newLen];
            int[][] paper2 = new int[newLen][newLen];
            int[][] paper3 = new int[newLen][newLen];
            int[][] paper4 = new int[newLen][newLen];
            int[][] paper5 = new int[newLen][newLen];
            int[][] paper6 = new int[newLen][newLen];
            int[][] paper7 = new int[newLen][newLen];
            int[][] paper8 = new int[newLen][newLen];
            int[][] paper9 = new int[newLen][newLen];

            for(int i=0; i<newLen; i++){
                System.arraycopy(paper[i], 0, paper1[i], 0, newLen);
                System.arraycopy(paper[i], newLen, paper2[i], 0, newLen);
                System.arraycopy(paper[i], newNewLen, paper3[i], 0, newLen);
                System.arraycopy(paper[i+newLen], 0, paper4[i], 0, newLen);
                System.arraycopy(paper[i+newLen], newLen, paper5[i], 0, newLen);
                System.arraycopy(paper[i+newLen], newNewLen, paper6[i], 0, newLen);
                System.arraycopy(paper[i+newNewLen], 0, paper7[i], 0, newLen);
                System.arraycopy(paper[i+newNewLen], newLen, paper8[i], 0, newLen);
                System.arraycopy(paper[i+newNewLen], newNewLen, paper9[i], 0, newLen);
            }

            cutPaper(paper1);
            cutPaper(paper2);
            cutPaper(paper3);
            cutPaper(paper4);
            cutPaper(paper5);
            cutPaper(paper6);
            cutPaper(paper7);
            cutPaper(paper8);
            cutPaper(paper9);
        }
    }

    public static boolean checkPaper(int[][] paper){
        boolean isPerfect = true;
        int len = paper[0].length;
        int which;

        if(paper[0][0] == 1) which = 1;
        else if(paper[0][0] == 0) which = 0;
        else which = -1;

        outer: for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(paper[i][j] != which){
                    isPerfect = false;
                    break outer;
                }
            }
        }

        if(isPerfect){
            if(which == 1) oneCount += 1;
            else if(which == 0) zeroCount += 1;
            else mOneCount += 1;
        }

        return isPerfect;
    }
}