import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P1541MissingBraket{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String line = br.readLine();

        // Logic
        // 1. 숫자와 연산자를 따로 저장
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> operators =  new ArrayList<>();
        int len = line.length();
        for(int i=0; i<len; i++){
            char one = line.charAt(i);
            if(one == '+' || one == '-'){
                operators.add(one);
                numbers.add(Integer.parseInt(sb.toString()));
                sb.delete(0, sb.length());
            }
            else{
                sb.append(one);
            }
        }
        numbers.add(Integer.parseInt(sb.toString()));
        sb.delete(0, sb.length());

        // 2. 더하기 연산을 먼저 실행
        len = operators.size();
        int now, numNow, numNext;
        for(int i=0; i<len; i++){
            if(operators.contains('+')){
                now = operators.indexOf('+');
                operators.remove(now);
                numNow = numbers.get(now);
                numNext = numbers.get(now+1);
                numbers.remove(now+1);
                numbers.remove(now);
                numbers.add(now, numNow+numNext);
            }
            else{
                break;
            }
        }

        // 3. 그 다음 뺄셈 연산을 실행
        len = numbers.size();
        int result = numbers.get(0);
        for(int i=1; i<len; i++){
            result -= numbers.get(i);
        }
        sb.append(result);
        
        // Print
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}