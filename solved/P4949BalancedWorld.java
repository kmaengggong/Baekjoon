import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P4949BalancedWorld{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 로직
        Stack<Character> brackets = new Stack<>();
        String line = br.readLine();
        boolean isBalanced;

        while(!line.equals(".")){
            isBalanced = true;
            int len = line.length();

            for(int i=0; i<len; i++){
                char word = line.charAt(i);
                if(word == '[' || word == '('){
                    brackets.push(word);
                }
                else if(brackets.size() == 0){
                    if(word == ']' || word == ')'){
                        isBalanced = false;
                        break;
                    }
                }
                else if(word == ']'){
                    if(brackets.pop() != '['){
                        isBalanced = false;
                        break;
                    }
                }
                else if(word ==')'){
                    if(brackets.pop() != '('){
                        isBalanced = false;
                        break;
                    }
                }
            }
            if(brackets.size() != 0) sb.append("no").append("\n");
            else if(isBalanced) sb.append("yes").append("\n");
            else sb.append("no").append("\n");

            brackets.clear();

            line = br.readLine();
        }
        
        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}