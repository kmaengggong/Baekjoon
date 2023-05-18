import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14719Raindrops{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] map = new int[w];

        int input;
        int max = 0;
        int maxIndex = -1;
        for(int i=0; i<w; i++){
            input =  Integer.parseInt(st.nextToken());
            map[i] = input;
            if(input > max){
                max = input;
                maxIndex = i;
            }
        }

        // Logic
        if(max == 0) sb.append(0);
        else{
            int left = maxIndex;
            int right = maxIndex;
            int leftMax = 0, leftMaxIndex = 0;
            int rightMax = 0, rightMaxIndex = 0;
            int now;
            int raindrops = 0;

            while(left > 0){
                for(int i=0; i<left; i++){
                    now = map[i];
                    if(now > leftMax){
                        leftMax = now;
                        leftMaxIndex = i;
                    }
                }
                if(leftMax == 0) break;
                for(int i=leftMaxIndex+1; i<left; i++){
                    raindrops += leftMax-map[i];
                }
                left = leftMaxIndex;
                leftMax = 0;
            }
            while(right < w-1){
                for(int i=right+1; i<w; i++){
                    now = map[i];
                    if(now > rightMax){
                        rightMax = now;
                        rightMaxIndex = i;
                    }
                }
                if(rightMax == 0) break;
                for(int i=right+1; i<rightMaxIndex; i++){
                    raindrops += rightMax-map[i];
                }
                right = rightMaxIndex;
                rightMax = 0;
            }

            sb.append(raindrops);
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}