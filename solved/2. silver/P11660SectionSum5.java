import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11660SectionSum5{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 표의 크기 n x n
        int m = Integer.parseInt(st.nextToken());  // 합을 구해야 하는 횟수

        int[][] nums = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Logic
        int[][] sums = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                sums[i][j] = sums[i][j-1] + nums[i-1][j-1];
            }
        }

        int x1, y1, x2, y2;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int j=x1; j<=x2; j++){
                sum += sums[j][y2] - sums[j][y1-1];
            }
            sb.append(sum).append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}