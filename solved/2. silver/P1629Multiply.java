// long을 쓰자

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1629Multiply{
    static StringBuffer sb;
    static int a, b, c;
    static Map<Integer, Long> map;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // Logic
        map = new HashMap<>();
        map.put(1, (long)a%c);

        long result = recursiveFunc(b);

        sb.append(result);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static long recursiveFunc(int count){
        if(count%2 == 0){
            if(!map.containsKey(count)){
                BigInteger bi = new BigInteger(Long.toString(recursiveFunc(count/2)%c));
                bi = bi.pow(2);
                bi = bi.mod(new BigInteger(Integer.toString(c)));
                map.put(count, bi.longValue());
            }
        }
        else{
            if(!map.containsKey(count)){
                BigInteger bi = new BigInteger(Long.toString(recursiveFunc(count/2)%c));
                bi = bi.pow(2);
                bi = bi.multiply(new BigInteger(Long.toString(a%c)));
                bi = bi.mod(new BigInteger(Integer.toString(c)));
                map.put(count, bi.longValue());
            }
        }
        return map.get(count);
    }
}