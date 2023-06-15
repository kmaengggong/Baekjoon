import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15654NAndM5{
    static StringBuffer sb;
    static int n, m;
    static int[] numbers, answerArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        answerArr = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);

        // Logic
        for(int i=0; i<n; i++){
            visited[i] = true;
            answerArr[0] = numbers[i];
            printNAndM(i, 1);
            visited[i] = false;
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void printNAndM(int idx, int depth){
        if(depth >= m){
            for(int answer : answerArr){
                sb.append(answer).append(" ");
            }
            sb.append("\n");
            visited[idx] = false;

            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                answerArr[depth] = numbers[i];
                printNAndM(i, depth+1);
                visited[i] = false;
            }
        }
    }
}