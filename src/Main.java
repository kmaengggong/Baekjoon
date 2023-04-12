import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class Main{
    //public static HashSet<Integer> preDecimals = new HashSet<>();
    public static HashSet<Integer> getDecimals(int n){
        int sqrt;
        HashSet<Integer> decimals = new HashSet<>();

        /*
        outer: for(int i=2; i<n; i++){
            if(preDecimals.contains(i)){
                decimals.add(i);
                continue;
            }
            sqrt = (int)Math.sqrt(i);
            for(int j=2; j<=sqrt; j++){
                if(i % j == 0) continue outer;
            }
            decimals.add(i);
            preDecimals.add(i);
        }
        */
        // 에라토스테네스의 체를 이용해서 소수를 구함

        return decimals;
    }

    public static int countGoldbach(int n){
        ArrayList<Integer> decimals = new ArrayList<>();//getDecimals(n);
        for(int i=2; i<n; i++){
            decimals.add(i);
        }
        for(int i=2; (i*i)<n; i++){
            for(int j=(i*i); j<n; j++) decimals.remove(Integer.valueOf(j));
        }
        int cnt = 0;
        ArrayList<Integer> temp = new ArrayList<>(decimals);

        // temp를 이용해 중복되는 소수 조합 반으로 줄임
        for(int i=0; i<decimals.size(); i++){
            temp.remove(Integer.valueOf(i));
            int x = decimals.get(i);
            for(int j=0; j<temp.size(); j++){
                if(x + decimals.get(j) == n){
                    cnt += 1;
                }
            }
            if(x + x == n){
                cnt += 1;           
            }
        }

        return cnt;
    }

	public static void main(String[] args) throws IOException{
		// 입력 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 메인 로직
        // 1. 짝수 n에 대해 2~n-1 까지 소수(decimals)를 구하고
        // 2. decimals * decimals 해서 더해서 짝수 n이 나오는 수 카운팅
        int t = Integer.parseInt(br.readLine());
        int result;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            result = countGoldbach(Integer.parseInt(br.readLine()));
            sb.append(result).append("\n");
        }

        // 출력 결과
        bw.write(sb.toString());

		br.close();
		bw.flush();
		bw.close();
	}
}