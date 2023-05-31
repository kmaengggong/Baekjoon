import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1969DNA{
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] acgts = new int[m][4];

        for(int i=0; i<n; i++){
            char[] lines = br.readLine().toCharArray();
            int j = 0;
            for(char c : lines){
                switch(c){
                    case 'A':   acgts[j][0] += 1; break;
                    case 'C':   acgts[j][1] += 1; break;
                    case 'G':   acgts[j][2] += 1; break;
                    case 'T':   acgts[j][3] += 1; break;
                }
                j += 1;
            }
        }

        // Logic
        int hd = 0;
        for(int i=0; i<m; i++){
            int max = 0;
            int maxIdx = 0;
            int acgt;

            for(int j=0; j<4; j++){
                acgt = acgts[i][j];    
                hd += acgt;
                if(acgt > max){
                    max = acgt;
                    maxIdx = j;
                }
            }
            hd -= max;
            switch(maxIdx){
                case 0:     sb.append('A'); break;
                case 1:     sb.append('C'); break;
                case 2:     sb.append('G'); break;
                case 3:     sb.append('T'); break;
            }
        }

        sb.append("\n").append(hd);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
;    }
}