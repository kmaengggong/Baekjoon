import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1259PalindromeNumber{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String line = br.readLine();
        
        // 로직
        while(!line.equals("0")){
            int len = line.length();
            int t = Integer.parseInt(line);
            if(len == 1){
                sb.append("yes").append("\n");
                line = br.readLine();
                continue;
            }

            int[] nums = new int[len];
            boolean isOdd = true;
            if(len%2 == 0) isOdd = false;

            // 1231 -> {1, 3} - {2, 1}
            // 12521 -> {1, 2} - {5, 2, 1}
            for(int i=0; i<len/2; i++){
                nums[i] = t % 10;
                t /= 10;
            }

            // {2, 1} - {3, 1}
            // {5, 2, 1} = {2, 1}
            for(int i=len/2, j=(len/2-1); i<len; i++){
                nums[i] = t % 10;
                t /= 10;
                
                if(isOdd){
                    isOdd = false;
                    continue;
                }
                
                if(nums[j] != nums[i]){
                    sb.append("no").append("\n");
                    j -= 1;
                    break;
                }
                j -= 1;
                if(i == len-1) sb.append("yes").append("\n");
            }

            line = br.readLine();
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}