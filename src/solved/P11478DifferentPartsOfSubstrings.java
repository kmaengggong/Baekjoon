import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class P11478DifferentPartsOfSubstrings{
    public static void main(String[] args) throws IOException{
        // 입력 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        // 메인 로직
        // 컬렉션: 중복 x. 순서 x. => HashSet
        HashSet<String> subStrings = new HashSet<>();
        int strLength = str.length();

        for(int i=0; i<strLength; i++){
            for(int j=0; j<strLength-i; j++){
                subStrings.add(str.substring(j, j+i+1));
            }
        }

        // 출력 결과
        bw.write(subStrings.size() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}