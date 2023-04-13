import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class P10816NumberCards2{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N: 중복 o, 순서 x
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cards = new HashMap<>();
        String[] line = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            int card = Integer.parseInt(line[i]); 
            if(cards.containsKey(card)) cards.replace(card, cards.get(card)+1);
            else cards.put(Integer.parseInt(line[i]), 1);
        }

        // 메인 로직
        // !. 배열로 한 게 StringBuilder 쓴 것보다 빠름...
        int m = Integer.parseInt(br.readLine());
        int[] results = new int[m];
        String[] line2 = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            int card = Integer.parseInt(line2[i]);
            if(cards.containsKey(card)) results[i] = cards.get(card);
        }

        // 출력 결과
        for(int result : results) bw.write(result + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}