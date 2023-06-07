import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P15656NAndM7{
    static StringBuffer sb = new StringBuffer();
    static int n, m;
    static ArrayList<Integer> arr;
    static ArrayList<Integer[]> arr2;
    static int[] answerArr;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);
        arr2 = new ArrayList<>();

        int i = 0;
        for(int j : arr){
            arr2.add(new Integer[]{i++, j});
        }

        // Logic
        answerArr = new int[m];
        for(Integer[] its : arr2){
            answerArr[0] = its[1];
            dfs(its, 1);
        }

        // Output
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(Integer[] nums, int len){
        if(len >= m){
            for(int i : answerArr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(Integer[] its : arr2){
            answerArr[len] = its[1];
            dfs(its, len+1);
        }
    }
}