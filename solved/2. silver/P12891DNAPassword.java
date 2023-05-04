import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P12891DNAPassword{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());  // 문자열 길이
        int p = Integer.parseInt(st.nextToken());  // 부분 문자열 길이

        char[] dnas = new char[s];
        for(int i=0; i<s; i++){
            dnas[i] = (char)br.read();
        }
        br.readLine();
        
        st = new StringTokenizer(br.readLine());
        int aLength = Integer.parseInt(st.nextToken());
        int cLength = Integer.parseInt(st.nextToken());
        int gLength = Integer.parseInt(st.nextToken());
        int tLength = Integer.parseInt(st.nextToken());

        // Logic
        int count = 0;
        int[] acgts = new int[4];
        char dna;
        for(int i=0; i<p; i++){
            dna = dnas[i];
            if(dna == 'A') acgts[0] += 1;
            else if(dna == 'C') acgts[1] += 1;
            else if(dna == 'G') acgts[2] += 1;
            else acgts[3] += 1;
        }

        if(acgts[0] >= aLength && acgts[1] >= cLength && acgts[2] >= gLength && acgts[3] >= tLength){
            count += 1;
        }
        
        int len = s-p;
        int startIndex = 1;
        int endIndex = p;
        
        char rem, add;
        for(int i=1; i<=len; i++){
            rem = dnas[startIndex-1];
            if(rem == 'A') acgts[0] -= 1;
            else if(rem == 'C') acgts[1] -= 1;
            else if(rem == 'G') acgts[2] -= 1;
            else acgts[3] -= 1;

            add = dnas[endIndex];
            if(add == 'A') acgts[0] += 1;
            else if(add == 'C') acgts[1] += 1;
            else if(add == 'G') acgts[2] += 1;
            else acgts[3] += 1;

            if(acgts[0] >= aLength && acgts[1] >= cLength && acgts[2] >= gLength && acgts[3] >= tLength){
                count += 1;
            }

            startIndex += 1;
            endIndex += 1;
        }
        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

/* 정답코드: 256ms -> 368ms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static int arrCheck[];
    static int arrWindow[];
    static int checkSecret;

    public static void add(char c){
        switch(c){
            case 'A':
                arrWindow[0] += 1;
                if(arrWindow[0] == arrCheck[0]) checkSecret += 1;
                break;
            case 'C':
                arrWindow[1] += 1;
                if(arrWindow[1] == arrCheck[1]) checkSecret += 1;
                break;
            case 'G':
                arrWindow[2] += 1;
                if(arrWindow[2] == arrCheck[2]) checkSecret += 1;
                break;
            case 'T':
                arrWindow[3] += 1;
                if(arrWindow[3] == arrCheck[3]) checkSecret += 1;
                break;
        }
    }

    public static void remove(char c){
        switch(c){
            case 'A':
                if(arrWindow[0] == arrCheck[0]) checkSecret -= 1;
                arrWindow[0] -= 1;
                break;
            case 'C':
                if(arrWindow[1] == arrCheck[1]) checkSecret -= 1;
                arrWindow[1] -= 1;
                break;
            case 'G':
                if(arrWindow[2] == arrCheck[2]) checkSecret -= 1;
                arrWindow[2] -= 1;
                break;
            case 'T':
                if(arrWindow[3] == arrCheck[3]) checkSecret -= 1;
                arrWindow[3] -= 1;
                break;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int result = 0;
        char dnas[] = new char[s];
        arrCheck = new int[4];
        arrWindow = new int[4];

        checkSecret = 0;
        dnas = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            arrCheck[i] = Integer.parseInt(st.nextToken());
            if(arrCheck[i] == 0) checkSecret += 1;
        }

        // Logic
        for(int i=0; i<p; i++){
            add(dnas[i]);
        }

        if(checkSecret == 4) result += 1;

        for(int i=p; i<s; i++){
            int j = i-p;
            add(dnas[i]);
            remove(dnas[j]);
            if(checkSecret == 4) result += 1;
        }

        sb.append(result);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */