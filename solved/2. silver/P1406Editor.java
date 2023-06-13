import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P1406Editor{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        char[] input = br.readLine().toCharArray();

        int n = Integer.parseInt(br.readLine());

        Stack<Character> frontStack = new Stack();
        Stack<Character> backStack = new Stack();

        for(char c : input) frontStack.add(c);

        for(int i=0; i<n; i++){
            char[] cmd = br.readLine().toCharArray();

            // Logic
            char c = cmd[0];

            switch(c){
                case 'L':
                    if(!frontStack.isEmpty()) backStack.add(frontStack.pop());
                    break;
                case 'D':
                    if(!backStack.isEmpty()) frontStack.add(backStack.pop());
                    break;
                case 'B':
                    if(!frontStack.isEmpty()) frontStack.pop();
                    break;
                case 'P':
                    frontStack.add(cmd[2]);
                    break;
                default:
                    break;
            }
        }
        
        for(char c : frontStack) sb.append(c);
        while(!backStack.isEmpty()) sb.append(backStack.pop());

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}