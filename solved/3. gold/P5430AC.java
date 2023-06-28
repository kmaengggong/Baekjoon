import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P5430AC{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<t; i++){
            char[] functions = br.readLine().toCharArray();

            int n = Integer.parseInt(br.readLine());

            StringBuffer inputSB = new StringBuffer(br.readLine());
            inputSB.delete(0, 1);
            inputSB.delete(inputSB.length()-1, inputSB.length());
            st = new StringTokenizer(inputSB.toString());
            
            Deque<Integer> deq = new LinkedList<>();

            for(int j=0; j<n; j++){
                deq.add(Integer.parseInt(st.nextToken(",")));
            }

            // Logic
            boolean isError = false;
            boolean isReverse = false;

            outer:for(char c : functions){
                switch(c){
                    case 'R':
                        isReverse = isReverse ? false : true;
                        break;
                    case 'D':
                        if(deq.isEmpty()){
                            isError = true;
                            break outer;
                        }
                        if(!isReverse){
                            deq.poll();
                        }
                        else{
                            deq.pollLast();
                        }
                        break;
                }
            }

            if(isError) sb.append("error").append("\n");
            else{
                if(deq.isEmpty()) sb.append("[]\n");
                else{
                sb.append("[");
                if(!isReverse){
                    while(!deq.isEmpty()){
                        sb.append(deq.poll()).append(",");
                    }
                }
                else{
                    while(!deq.isEmpty()){
                        sb.append(deq.pollLast()).append(",");
                    }
                }
                sb.delete(sb.length()-1, sb.length());
                sb.append("]\n");
                }
            }
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}