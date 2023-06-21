import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2805TreeCutting{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[n];

        for(int i=0; i<n; i++) trees[i] = Integer.parseInt(st.nextToken());

        // Logic
        Arrays.sort(trees);

        long[] sums = new long[n];
        sums[0] = trees[0];

        for(int i=1; i<n; i++) sums[i] = sums[i-1] + trees[i];

        if(sums[n-1] <= m){
            sb.append("0");
        }
        else{
            long startVal = 0;
            long endVal = trees[n-1];
            long midVal = (startVal+endVal)/2;
            long sum = 0;

            while(startVal != midVal && endVal != midVal){
                sum = sums[n-1];
                int breakIdx = 0;

                for(int i=0; i<n; i++){
                    if(trees[i] > midVal){
                        breakIdx = i-1;
                        break;
                    }
                }

                if(breakIdx >= 0){
                    sum -= sums[breakIdx];
                    sum -= midVal * (n-breakIdx-1);
                }
                else{
                    sum -= midVal * n;
                }

                if(sum < m) endVal = midVal;
                else if(sum > m) startVal = midVal;
                else break;

                if(sum == m) break;

                midVal = (startVal+endVal)/2;
            }

            sb.append(midVal);
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

/* 정답 코드: 960ms -> 580ms
 * 정렬하면 더 느림
 * 이분탐색을 0~수 범위로 시작
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[n];

        for(int i=0; i<n; i++) trees[i] = Integer.parseInt(st.nextToken());

        // Logic

        int start = 0;
        int end = 1000000000;

        while(start+1 < end){
            int mid = (start+end)/2;

            long sum = 0;
            for(int i=0; i<n; i++){
                if(trees[i] > mid) sum += trees[i]-mid;
            }

            if(sum >= m) start = mid;
            else end = mid;
        }

        sb.append(start);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
*/