import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P4948BertrandsPostulate{
    public static int getDecimalsBetween(int a, int b){
        int sqrt;
        int cnt = 0;
        outer: for(int i=a+1; i<=b; i++){
            if(i == 1){
                continue;
            }
            if(i == 2){
                cnt += 1;
                continue;
            }
            sqrt = (int)Math.sqrt(i);
            for(int j=2; j<=sqrt; j++){
                if(i % j == 0) continue outer;
            }
            cnt += 1;
        }
        
        return cnt;
    }

	public static void main(String[] args) throws IOException{
		// 입력 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 메인 로직
        int a = Integer.parseInt(br.readLine());
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(a != 0) {
            count = getDecimalsBetween(a, a*2);
            sb.append(count).append("\n");
            a = Integer.parseInt(br.readLine());
        } 

        // 출력 결과
        bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();
	}
}