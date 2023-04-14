import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1018RedrawChessBoard{
    public static void main(String[] args) throws IOException{
        final char[][] wChessPan = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        };
        final char[][] bChessPan = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        };

        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);

        char[][] chessPan = new char[n][m];
        for(int i=0; i<n; i++){
            line = br.readLine();
            for(int j=0; j<m; j++){
                chessPan[i][j] = line.charAt(j);
            }
        }

        // 메인 로직
        // 1. 8x8 자르는 반복문
        int minCount = 2147000000;
        int count = 0;
        //char isNext;
        for(int i=0; i<n-7; i++){
            for(int j=0; j<m-7; j++){
                // 2. 자른 것에서 칠해야하는 갯수
                for(int k=i, a=0; k<i+8; k++, a++){ 
                    for(int l=j, b=0; l<j+8; l++, b++){
                        if(chessPan[k][l] != wChessPan[a][b]) count += 1;
                    }
                }
                if(count < minCount) minCount = count;
                count = 0;
                // 3. 역순으로 한 번 더 해야함
                for(int k=i, a=0; k<i+8; k++, a++){ 
                    for(int l=j, b=0; l<j+8; l++, b++){
                        if(chessPan[k][l] != bChessPan[a][b]) count += 1;
                    }
                }
                if(count < minCount) minCount = count;
                count = 0;
            }
        }

        // 출력 결과
        bw.write(minCount + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}