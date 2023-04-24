import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P4134NextDecimal{
	public static void main(String[] args) throws IOException{
		// 입력 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        long[] numbers = new long[t];
        for(int i=0; i<t; i++){
            numbers[i] = Long.parseLong(br.readLine());
        }

		// 메인 로직
        // 1. n이 소수임을 판별할 때, 1~n^1/2 까지 나눠서 나머지 0이 하나라도 나오면 소수x
		long now = 0;
		long sqrt = 0;
		long[] decimals = new long[t];
		boolean isDecimal;
		// 테스트 케이스 하나당
		for(int i=0; i<t; i++){
			now = numbers[i];
			// 씨발
			if(now == 0 || now == 1){
				decimals[i] = 2;
				continue;
			}
			isDecimal = false;

			// 소수가 나올때까지
			while(!isDecimal){
				sqrt = (long)(Math.sqrt(now));
				isDecimal = true;
				for(long j=2; j<=sqrt; j++){
					if(now % j == 0){
						isDecimal = false;
						now += 1;
						break;
					}
				}
				if(isDecimal){
					decimals[i] = now;
					break;
				} 
			}
		}

		// 출력 결과
		for(long decimal : decimals){
			bw.write(decimal + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}