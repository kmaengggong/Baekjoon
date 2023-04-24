import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1929FindDecimals{
	public static void main(String[] args) throws IOException{
		// 입력 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int m = Integer.parseInt(line.split(" ")[0]);
        int n = Integer.parseInt(line.split(" ")[1]);

		// 메인 로직
        StringBuilder sb = new StringBuilder();  // String Builder 쓰면 개빨라짐
        int sqrt = 0;
        boolean isDecimal;
        for(int i=m; i<=n; i++){
            if(i == 1 || i == 2){
                sb.append(2).append("\n");
                i = 2;
                continue;
            }
            isDecimal = true;
            sqrt = (int)Math.sqrt(i);
            for(int j=2; j<=sqrt; j++){
                if(i % j == 0){
                    isDecimal = false;
                    break;
                }
            }
            if(isDecimal && i>2){
                sb.append(i).append("\n");
            }
		}

        // 출력 결과
        bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();
	}
}