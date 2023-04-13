import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P13241LeastCommonMultiple{
	public static int getCommonFactor(int a, int b){
		if(a % b == 0) return b;
		else return getCommonFactor(b, a%b);
	}

	public static void main(String[] args) throws IOException{
		// 입력 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
                int locations[] = new int[n];
                for(int i=0; i<n; i++){
                        locations[i] = Integer.parseInt(br.readLine());
		}

		// 메인 로직
		// 1. 가로수 사이의 가장 짧은 거리 min과 나머지 거리들의 최대공약수를 죄다 구하고,
        // 최솟값이 전체 거리의 최대공약수이고, 곧 갭. 이 갭만큼 나무를 심으면 됨.
		int min = 0;
		int distance[] = new int[n-1];
		for(int i=0; i<n-1; i++){
			distance[i] = locations[i+1] - locations[i];
			if(i == 0){
				min = distance[i];
				continue;
			}
			if(distance[i] < min) min = distance[i];
		}

		int commonFactor = 0;
		int minCommonFactor = 0;
		for(int i=0; i<distance.length; i++){
			if(i == 0) minCommonFactor = getCommonFactor(distance[i], min);
			if(distance[i] == min) continue;
			commonFactor = getCommonFactor(distance[i], min);
			if(commonFactor < minCommonFactor) minCommonFactor = commonFactor;
		}

		// 2. 처음 거리부터 마지막 거리까지 갭만큼 나무를 심은 수 = 
        // (마지막 거리 - 처음 거리) / 갭 + 1
		int gapLocationsLength = (locations[n-1]-locations[0])/minCommonFactor + 1; 

		// 출력 결과
		bw.write((gapLocationsLength - n) + "\n");

		br.close();
		bw.flush();
		bw.close();
	}
}