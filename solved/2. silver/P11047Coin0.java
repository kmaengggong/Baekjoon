import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P11047Coin0{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);

        ArrayList<Integer> coins = new ArrayList<>();
        for(int i=0; i<n; i++){
            coins.add(Integer.parseInt(br.readLine()));
        }

        // Logic
        int coin;
        int coinCount = 0;
        int sum = 0;

        outer:for(int i=n-1; i>=0; i--){
            coin = coins.get(i);
            while(sum+coin <= k){
                sum += coin;
                coinCount += 1;
                if(sum == k) break outer;
            }
        }

        sb.append(coinCount);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}