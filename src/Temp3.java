import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.xml.namespace.QName;

public class Main{
    public static void main(String[] args) throws IOException{
        // 입력 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        // 로직
        // 666, 1666, 2666, 3666, 4666, 5666, 6660, 6661, 6662, ..., 6669,
        // 7666, 8666, 9666, 10666, 11666, 12666, ..., 16660, 16661, ..., 16669, 17666
        // 1. 앞에서 1~5까지는 그대로 n+666
        // 2. 6부터 0~9
        // 3. 7~9까지 그대로 
        StringBuilder sb = new StringBuilder();
        if(n == 0) sb.append(666);
        else{
            int step = 0;
            while(step < n){
                
            }
            for(int i=0; i<n; i++){
                for(int j=1; j<=n; j++){
                    sb.append(j);
                }
                sb.append(666);
            }
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}