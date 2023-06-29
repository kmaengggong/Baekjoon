import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<int[]> arr = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        
        // Logic
        Comparator<int[]> com = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        };
        Collections.sort(arr, com);

        int[] numbers = new int[n];
        for(int i=0; i<n; i++) numbers[i] = arr.get(i)[1];

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int count = 0;
            int now = numbers[i];
            for(int j=i+1; j<n; j++){
                if(numbers[j] < now) count += 1;
                else now = numbers[j];
            }
            count += i;
            if(count < min) min = count;
        }

        sb.append(min);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}