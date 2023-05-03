import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P10986SumOfLeft{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        long[] nums = new long[n+1];
        long num;
        for(int i=1; i<=n; i++){
            num = Long.parseLong(st.nextToken());
            nums[i] = num;
        }

        // Logic
        // 1. S[i]%3 = S[j]%3 인 i, j 값 찾고, 조합으로 계산.
        // 2. Tlqkf Long.
        long sum = 0;
        long left;
        HashMap<Long, Long> counts = new HashMap<>();
        for(int i=1; i<=n; i++){
            sum += nums[i];
            left = sum%m;
            if(!counts.containsKey(left)) counts.put(left, 1l);
            else counts.put(left, counts.get(left)+1);
        }

        long result = 0;
        long count;
        for(long l : counts.keySet()){
            count = counts.get(l);
            if(l == 0) result += count;
            if(count == 1){
                continue;
            }
            else{
                result += count * (count-1) / 2;
            }
        }

        sb.append(result);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

/* 정답 코드: 716ms -> 528ms
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        long result = 0;
        
        long[] sums = new long[n];
        sums[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++){
            sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
        }

        // Logic
        long[] checks = new long[m];
        int check;
        for(int i=0; i<n; i++){
            check = (int)(sums[i]%m);
            if(check == 0) result += 1;
            checks[check] += 1;
        }

        for(int i=0; i<m; i++){
            if(checks[i] > 1){
                result += checks[i] * (checks[i]-1) / 2;
            }
        }
        sb.append(result);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */