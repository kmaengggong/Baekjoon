import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class P10825KookYongSoo{
    static class Scores implements Comparator<Scores>{
        String name;
        int korean;
        int english;
        int math;

        Scores(){};
        Scores(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compare(Scores s1, Scores s2){
            if(s1.korean > s2.korean) return 1;
            else if(s1.korean < s2.korean) return 0;
            else if(s1.english < s2.english) return 1;
            else if(s1.english > s2.english) return 0;
            else if(s1.math > s2.math) return 1;
            else if(s1.math < s2.math) return 0;
            else{
                int len;
                if(s1.name.length() > s2.name.length()) len = s1.name.length();
                else len = s2.name.length(); 
                for(int i=0; i<len; i++){
                    if(s1.name.charAt(i) < s2.name.charAt(i)) return 1;
                    else if(s1.name.charAt(i) > s2.name.charAt(i)) return 0;
                }
                return -1;
            }
        }
    }

    static void mergeSort(Scores[] scores){
        if(scores == null) return;
        int len = scores.length;
        if(len > 1){
            int mid = len / 2;
            Scores[] left = Arrays.copyOfRange(scores, 0, mid);
            Scores[] right = Arrays.copyOfRange(scores, mid, len);

            mergeSort(left);
            mergeSort(right);

            int i=0;
            int j=0;
            int k=0;
            while(i < left.length && j < right.length){
                if(scores[0].compare(left[i], right[j]) == 1) scores[k++] = left[i++];
                else scores[k++] = right[j++];
            }
            while(i < left.length) scores[k++] = left[i++];
            while(j < right.length) scores[k++] = right[j++];
        }
    }

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] lines;
        Scores[] scores = new Scores[n];

        for(int i=0; i<n; i++){
            lines = br.readLine().split(" ");
            Scores score = new Scores(
                lines[0],
                Integer.parseInt(lines[1]), 
                Integer.parseInt(lines[2]),
                Integer.parseInt(lines[3])
            );
            scores[i] = score;
        }

        // Logic
        /* 
            국어 점수가 감소하는 순서로
            국어 점수가 같으면 영어 점수가 증가하는 순서로
            국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
            모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
        */
        mergeSort(scores);
        
        for(int i=0; i<n; i++){
            sb.append(scores[i].name).append(" ").append("\n"); 
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}