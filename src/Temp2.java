import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Temp2{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        // N은 중복 O, 순서 X -> ArrayList.
        // M은 중복 X, 순서 O -> LinkedHashSet. 들어온 순서는 보장함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> iCards = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        String[] lines = br.readLine().split(" ");        
        for(int i=0; i<n; i++){
            iCards.add(Integer.parseInt(lines[i]));
        }

        LinkedHashSet<Integer> fCards = new LinkedHashSet<>();
        int m = Integer.parseInt(br.readLine());
        lines = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int fCard = 0;
        for(int i=0; i<m; i++){
            fCard = Integer.parseInt(lines[i]);
            iCards.forEach({
                if(i == lines[i]){
                    
                }
            });
            fCards.add(Integer.parseInt(lines[i]));
        }

        // 메인 로직
        
        // 출력 결과

        br.close();
        bw.flush();
        bw.close();
    }
}