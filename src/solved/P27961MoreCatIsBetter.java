import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

 public class P27961MoreCatIsBetter{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        
        // 로직
        long cat = 0;
        int count = 0;
        if(n != 0){
            // 생성 마법
            cat += 1;
            count += 1;

            // n=2 이상일 때
            long maxCopyCat = cat;
            while(cat < n){
                if(n-maxCopyCat >= 0) cat += maxCopyCat;
                else cat = n;
                
                maxCopyCat = cat;
                count += 1;
            }
        }

        // 출력
        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
 }