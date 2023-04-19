import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

 public class Main{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);  // 나무의 갯수
        int m = Integer.parseInt(lines[1]);  // 가져가려고 하는 나무의 길이
        
        String[] lines2 = br.readLine().split(" ");
        Integer[] trees = new Integer[n];
        for(int i=0; i<n; i++){
            int tree = Integer.parseInt(lines2[i]);
            trees[i] = tree;
        }
        Arrays.sort(trees);

        // 로직
        int result = 0;
        int mid = n/2;
        int gap = mid;
        int cutTrees;

        boolean isEnd = false;
        boolean isUp = false;
        while(true){
            cutTrees = 0;
            gap /= 2;
            if(gap < 1) break;
            for(int i=n-1; i>mid; i--){
                result = trees[mid];
                cutTrees += trees[i]-result;
            }
            if(cutTrees == m){
                isEnd = true;
                break;
            }
            else if(cutTrees > m){
                mid += gap;
                isUp = true;
            }
            else{
                mid -= gap;
                isUp = false;
            }
        }
        boolean isNoAnswer = false;
        while(!isEnd){
            for(int i=n-1; i>mid; i--){
                int cut = trees[i]-result;

            }
        }
        /*
        while(m-cutTrees >= 0){
            mid += mid>>1;
            cutTrees = 0;
            for(int i=n-1; i>=mid; i--){
                //int cut = trees[i]-mid;
                result = trees[mid];
                cutTrees += trees[i]-result;
                if()
            }

            if(cutTrees == m) break;

            gap >>= 1;
            if(gap == 0) gap += 1;

            if(cutTrees > m){
                result += gap;
            }
            else{
                result -= gap;
            }
        }*/

        // 출력
        bw.write(mid + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
 }