import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class P9507GenerationsOfTribbles{
    public static HashMap<Integer, Long> kkungfibos = new HashMap<>();

    public static long kkungFibo(int n){
        if(n < 1) return 1;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        else if(n == 3) return 4;
        else{
            long result = 0;

            if(!kkungfibos.containsKey(n-1)) kkungfibos.put(n-1, kkungFibo(n-1));
            result += kkungfibos.get(n-1);
            if(!kkungfibos.containsKey(n-2)) kkungfibos.put(n-2, kkungFibo(n-2));
            result += kkungfibos.get(n-2);
            if(!kkungfibos.containsKey(n-3)) kkungfibos.put(n-3, kkungFibo(n-3));
            result += kkungfibos.get(n-3);
            if(!kkungfibos.containsKey(n-4)) kkungfibos.put(n-4, kkungFibo(n-4));
            result += kkungfibos.get(n-4);

            return result;
        }
    }

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        // Logic
        int n;
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            kkungfibos.put(0, 1l);
            kkungfibos.put(1, 1l);
            kkungfibos.put(2, 2l);
            kkungfibos.put(3, 4l);
            sb.append(kkungFibo(n)).append("\n");
        }
                
        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}