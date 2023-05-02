import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.TreeMap;

public class P1213PalindromeMake{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // Logic
        // 홀수가 2개 이상 넘어가면 불가능
        HashMap<Character, Integer> chars = new HashMap<>();
        String line = br.readLine();
        int len = line.length();

        for(int i=0; i<len; i++){
            char now = line.charAt(i);
            if(chars.containsKey(now)){
                chars.put(now, chars.get(now)+1);
            }
            else{
                chars.put(now, 1);
            } 
        }

        int oddCount = 0;
        for(int entry : chars.values()){
            if(entry%2 == 1){
                oddCount += 1;
            }
            if(oddCount > 1) break;
        }

        if(oddCount > 1){
            sb.append("I'm Sorry Hansoo");
        }
        else{
            TreeMap<Character, Integer> orderedChars = new TreeMap<>();
            orderedChars.putAll(chars);

            char odd = ' ';
            for(char c : orderedChars.keySet()){
                int count = orderedChars.get(c);
                if(count%2 == 1){
                    odd = c;
                    orderedChars.put(c, count-1);
                    int l = count/2;
                    for(int i=0; i<l; i++) sb.append(c);
                }
                else{
                    int l = count/2;
                    for(int i=0; i<l; i++) sb.append(c);
                }
            }
            
            StringBuilder sb2 = new StringBuilder(sb.reverse());
            sb.reverse();
            if(odd != ' ') sb.append(odd);
            sb.append(sb2);
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}