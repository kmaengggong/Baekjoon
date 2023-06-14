import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P6603Lottery{
    static StringBuffer sb;
    static final int LOTTERY_LENGTH = 5;
    static int n;
    static int[] numbers;
    static int[] answerArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        String input = br.readLine();
        StringTokenizer st;
        
        while(!input.equals("0")){
            st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            numbers = new int[n];
            visited = new boolean[n];
            answerArr = new int[LOTTERY_LENGTH+1];

            for(int i=0; i<n; i++) numbers[i] = Integer.parseInt(st.nextToken());

            for(int i=0; i<n; i++){
                answerArr[0] = numbers[i];
                printCombination(i, 0);
                visited[i] = true;
            }
            sb.append("\n");

            input = br.readLine();
        }

        sb.deleteCharAt(sb.length()-1);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void printCombination(int num, int depth){
        visited[num] = true;
        answerArr[depth] = numbers[num];

        if(depth >= LOTTERY_LENGTH){
            for(int answer : answerArr) sb.append(answer).append(" ");
            sb.append("\n");

            return;
        }

        for(int i=num; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                printCombination(i, depth+1);
                visited[i] = false;
            }
        }

        visited[num] = false;
    }
}