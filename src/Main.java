import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        int[] floors = new int[n+1];
        for(int i=n; i>0; i--) floors[i] = Integer.parseInt(br.readLine());

        // Logic
        if(n < 3){
            int count = 0;
            for(int i=1; i<=n; i++){
                count += floors[i];
            }
            sb.append(count);
        }
        else{
            int len = (int)Math.ceil(n/2d) + 1;

            int[] noStepStart = new int[n+1];
            int[] yesStepStart = new int[n+1];

            noStepStart[1] = floors[1];
            yesStepStart[1] = floors[1];

            // no
            noStepStart[1] = noStepStart[0] + floors[2];
            if(n > 3) noStepStart[4] = noStepStart[1] + floors[4];
            int start = 5;
            while(start <= n){
                if(start+1 > n){
                    start                                                                                                                        
                }
                if(floors[start] >= floors[start+1]){
                    noStepStart[start] = noStepStart[start-1] + floors[start];
                    noStepStart[start+1] = noStepStart[start];
                    start += 2;
                }
                else{
                    
                }
            }

            // yes
            yesStepStart[3] = yesStepStart[1] + floors[3];
            start = 4;
            while(start <= n){

            }

            sb.append(noStepStart[n] >= yesStepStart[n] ? noStepStart[n] : yesStepStart[n]);
        }

        // Output
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }
}