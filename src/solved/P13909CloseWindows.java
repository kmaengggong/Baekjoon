import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P13909CloseWindows{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 메인 로직
        // N의 길이가 21억이라 배열로 0 1 체크하는 건 메모리 부족.
        // 아마 규칙을 찾아서 구하는 게 아닐가 싶음.
        int count = 0;
        for(int i=1, j=1; i<=n; j++, i=j*j){
            count += 1;
        }

        /* 로직 확인 : 1*1, 2*2, 3*3, 4*4, ... x*x < n 인 x의 갯수 
        boolean[] isOpen = new boolean[n+1];

        // 1번째 사람이 창문 다 염
        for(int i=1; i<=n; i++) isOpen[i] = true;
        System.out.println("[" + 1 + "]");
        for(int i=1; i<=n; i++){
            if(isOpen[i]) System.out.print(1 + " ");
            else System.out.print(0 + " ");
        }
        System.out.println();
        // 2번째 사람부터
        for(int i=2; i<=n; i++){
            for(int j=i, k=1; j<=n; k++, j=i*k){
                if(isOpen[j]) isOpen[j] = false;
                else isOpen[j] = true;
            }
            System.out.println("[" + i + "]");
            for(int j=1; j<=n; j++){
                if(isOpen[j]) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }

        int count = 0;
        for(int i=0; i<=n; i++){
            if(isOpen[i]) count += 1;
        }
        */

        // 출력 결과
        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}