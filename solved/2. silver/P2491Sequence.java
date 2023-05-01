import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2491Sequence{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] lines = br.readLine().split(" ");
        
        // Logic
        if(n == 1) sb.append(1).append("\n");
        else{
            int upCount = 1;
            int downCount = 1;
            int maxCount = Integer.MIN_VALUE;
            int before = Integer.parseInt(lines[0]);
            int now = Integer.parseInt(lines[1]);
            int idx = 2;
            
            while(now == before){
                if(idx < n-1) idx += 1;
                else break;
                
                upCount += 1;
                downCount += 1;
                before = now;
                now = Integer.parseInt(lines[idx]);
            }
            boolean isUp;
            if(now > before){
                upCount += 1;
                downCount = 1;
                isUp = true;
                if(upCount > maxCount) maxCount = upCount;
            }
            else{
                downCount += 1;
                upCount = 1;
                isUp = false;
                if(downCount > maxCount) maxCount = downCount;
            }

            before = now;

            for(int i=idx; i<n; i++){
                now = Integer.parseInt(lines[i]);

                if(now == before){
                    upCount += 1;
                    downCount += 1;
                    if(upCount > maxCount) maxCount = upCount;
                    if(downCount > maxCount) maxCount = downCount;
                }
                else if(now > before){
                    if(isUp){
                        isUp = true;
                        upCount += 1;
                        downCount = 1;
                        if(upCount > maxCount) maxCount = upCount;
                    }
                    else{
                        isUp = true;
                        downCount = 1;
                        upCount += 1;
                        if(downCount > maxCount) maxCount = downCount;
                    }
                }
                else{
                    if(isUp){
                        isUp = false;
                        upCount = 1;
                        downCount += 1;
                        if(upCount > maxCount) maxCount = upCount;
                    }
                    else{
                        isUp = false;
                        downCount += 1;
                        upCount = 1;
                        if(downCount > maxCount) maxCount = downCount;
                    }
                }
                before = now;
            }
            sb.append(maxCount).append("\n");
        }
                
        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}