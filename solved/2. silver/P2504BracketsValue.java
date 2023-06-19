import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P2504BracketsValue{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        char[] input = br.readLine().toCharArray();

        // Logic
        int len = input.length;
        Stack<IntChar> stack = new Stack<>();

        outer:for(char c : input){
            switch(c){
                case '(':
                    stack.push(new IntChar(c));
                    break;
                case '[':
                    stack.push(new IntChar(c));
                    break;
                case ')':
                    if(stack.isEmpty()){
                        stack.add(new IntChar(0));
                        break outer;
                    }
                    if(stack.peek().c == '('){
                        stack.pop();
                        if(!stack.isEmpty()){
                            if(!(stack.peek().c == '(' || stack.peek().c == '[')){
                                stack.push(new IntChar(stack.pop().n + 2));
                                break;
                            }
                        }
                        stack.push(new IntChar(2));
                    }
                    else if(stack.peek().c == '['){
                        stack.removeAllElements();
                        stack.add(new IntChar(0));
                        break outer;
                    }
                    else{
                        int i = 2 * stack.pop().n;
                        if(stack.isEmpty() || stack.peek().c != '('){
                            stack.add(new IntChar(0));
                            break outer;
                        }
                        stack.pop();
                        while(!stack.isEmpty()){
                            if(stack.peek().c == '(' || stack.peek().c == '[') break;
                            i +=  stack.pop().n;
                        }
                        stack.push(new IntChar(i));
                    }
                    break;
                case ']':
                    if(stack.isEmpty()){
                        stack.add(new IntChar(0));
                        break outer;
                    }
                    if(stack.peek().c == '['){
                        stack.pop();
                        if(!stack.isEmpty()){
                            if(!(stack.peek().c == '(' || stack.peek().c == '[')){
                                stack.push(new IntChar(stack.pop().n + 3));
                                break;
                            }
                        }
                        stack.push(new IntChar(3));
                    }
                     else if(stack.peek().c == '('){
                        stack.removeAllElements();
                        stack.add(new IntChar(0));
                        break outer;
                    }
                    else{
                        int i = 3 * stack.pop().n;
                        if(stack.isEmpty() || stack.peek().c != '['){
                            stack.add(new IntChar(0));
                            break outer;
                        }
                        stack.pop();
                        while(!stack.isEmpty()){
                            if(stack.peek().c == '(' || stack.peek().c == '[') break;
                            i += stack.pop().n;
                        }
                        stack.push(new IntChar(i));
                    }
                    break;
                default:
                    break;
            }
        }

        if(stack.size() > 1) sb.append("0");
        else sb.append(stack.pop().n);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

class IntChar{
    int n;
    char c;

    public IntChar(int n){
        this.n = n;
    }
    public IntChar(char c){
        this.c = c;
    }
    public IntChar(int n, char c){
        this.n = n;
        this.c = c;
    }
}