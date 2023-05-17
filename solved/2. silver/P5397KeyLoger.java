import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P5397KeyLoger{
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());

        char[] input;

        int key;
        for(int i=0; i<t; i++){
            input = br.readLine().toCharArray();

            // Logic
            Stack<Character> stack = new Stack<>();
            Stack<Character> save = new Stack<>();
            for(char c : input){
                if(c == '<'){
                    if(!stack.isEmpty()) save.push(stack.pop());
                }
                else if(c == '>'){
                    if(!save.isEmpty()) stack.push(save.pop());
                }
                else if(c == '-'){
                    if(!stack.isEmpty()) stack.pop();
                }
                else stack.push(c);
                System.out.println(stack.toString() + " " + save.toString());
            }

            if(!save.isEmpty()){
                while(!save.isEmpty()){
                    stack.push(save.pop());
                }
            }

            for(char c : stack) sb.append(c);
            sb.append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}