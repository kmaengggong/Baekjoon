import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P13305GasStation{
    static StringBuffer sb;
    
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        int[] distances = new int[n-1];
        int[] cities = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = n-1;
        for(int i=0; i<len; i++) distances[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) cities[i] = Integer.parseInt(st.nextToken());
        
        // Logic
        BigInteger result = new BigInteger("0");
        BigInteger add = new BigInteger(Integer.toString(cities[0]));
        add = add.multiply(new BigInteger(Integer.toString(distances[0])));
        result = result.add(add);
        int min = 0;

        for(int i=1; i<len; i++){
            if(cities[min] <= cities[i]){
                add = new BigInteger(Integer.toString(cities[min]));
                add = add.multiply(new BigInteger(Integer.toString(distances[i])));
                result = result.add(add);
            }
            else{
                add = new BigInteger(Integer.toString(cities[i]));
                add = add.multiply(new BigInteger(Integer.toString(distances[i])));
                result = result.add(add);
                min = i;
            }
        }

        sb.append(result.toString());

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}