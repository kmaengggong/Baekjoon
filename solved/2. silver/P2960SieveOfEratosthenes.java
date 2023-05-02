import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class P2960SieveOfEratosthenes{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);

        // Logic
        int count = 0;
        int result = 0;
        HashSet<Integer> deleted = new HashSet<>();

        outer:for(int i=2; i<=n; i++){
            for(int j=i; j<=n; j+=i){
                if(!deleted.contains(j)){
                    deleted.add(j);
                    count += 1;
                    if(count == k){
                        result = j;
                        break outer;
                    }
                }
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