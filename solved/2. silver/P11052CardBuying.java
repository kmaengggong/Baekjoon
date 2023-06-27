import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P11052CardBuying{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Comparator<P> com = new Comparator<>() {
            @Override
            public int compare(P o1, P o2){
                if(o1.cost > o2.cost) return -1;
                else if(o1.cost < o2.cost) return 1;
                else return 0;
            }
        };

        P[] p = new P[n+1];
        p[0] = new P(0, 0, 0);
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            int now = Integer.parseInt(st.nextToken());
            //pq.add(new P(i, now, now/(double)i));
            p[i] = new P(i, now, now/(double)i);
        }
        dp[1] = p[1].value;
        Arrays.sort(p, com);

        for(int i=2; i<=n; i++){
            int max = Integer.MIN_VALUE;

            for(int j=0; j<=n; j++){
                int left = i;
                int cost = 0;
                int start = j;

                while(left > 0){
                    if(dp[left] > 0){
                        cost += dp[left];
                        break;
                    }
                    P now = p[start];
                    if(now.idx == 0) break;

                    if(left-now.idx >= 0){
                        left -= now.idx;
                        cost += now.value;
                    }
                    else start += 1;
                }

                max = Math.max(max, cost);
            }

            dp[i] = max;
        }

        sb.append(dp[n]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

class P{
    int idx;
    int value;
    double cost;

    public P(int idx, int value, double cost){
        this.idx = idx;
        this.value = value;
        this.cost = cost;
    }
}

/* 정답코드: 348ms -> 144ms
 * 대체 이딴 식이 어떻게 나온거임?
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
    
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }

        // Logic
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i/2; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
            }
        }

        sb.append(dp[n]);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */