import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P2309SevenDwarves{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        final int N = 9;
        int[] dwarves = new int[N];
        int sum = 0;

        for(int i=0; i<N; i++){
            dwarves[i] = Integer.parseInt(br.readLine());
            sum += dwarves[i];    
        }

        // Logic
        Arrays.sort(dwarves);
        int[] result = new int[2];

        outer: for(int i=0; i<N; i++){
            int temp = sum - dwarves[i];  // 현재 수를 제외한 8난쟁이의 키 합
            for(int j=0; j<N; j++){
                if(i == j) continue;  // 자기 자신은 넘어감
                if((temp-dwarves[j]) == 100){
                    result = new int[]{i, j};
                    break outer;
                }
            }
        }

        for(int i=0; i<N; i++){
            if(!(i == result[0] || i == result[1])){
                sb.append(dwarves[i]).append("\n");
            }
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}