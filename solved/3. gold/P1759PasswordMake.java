import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1759PasswordMake{
    static StringBuffer sb;
    static int l, c;
    static char[] alphabets;
    static boolean[] visited;
    static char[] results;
    static HashSet<Character> vowels = new HashSet<>();

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alphabets = new char[c];
        visited = new boolean[c];
        results = new char[l+1];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<c; i++){
            alphabets[i] = st.nextToken().charAt(0);
        }

        // Logic
        Arrays.sort(alphabets);

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for(int i=0; i<c; i++){
            if(!visited[i]){
                visited[i] = true;
                if(vowels.contains(alphabets[i])) backTracking(i, 1, 1, 0);
                else backTracking(i, 1, 0, 1);
            }
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void backTracking(int idx, int depth, int vCount, int cCount){
        results[depth] = alphabets[idx];

        if(depth == l){
            if(vCount > 0 && cCount > 1){
                for(int i=1; i<=l; i++) sb.append(results[i]);
                sb.append("\n");
            }
            return;
        }

        for(int i=idx+1; i<c; i++){
            if(!visited[i]){
                visited[i] = true;
                if(vowels.contains(alphabets[i])) backTracking(i, depth+1, vCount+1, cCount);
                else backTracking(i, depth+1, vCount, cCount+1);
                visited[i] = false;
            }
        }
    }
}