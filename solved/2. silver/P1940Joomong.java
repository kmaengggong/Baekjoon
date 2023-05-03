import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940Joomong{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] materials = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            materials[i] = Integer.parseInt(st.nextToken());
        }

        // Logic
        Arrays.sort(materials);
        
        int startIndex = 0;
        int endIndex = n-1;
        int count = 0;
        int sum = materials[startIndex] + materials[endIndex];
        while(startIndex < endIndex){
            if(sum == m){
                count += 1;
                sum -= materials[endIndex];
                endIndex -= 1;
                sum += materials[endIndex];
            }
            else if(sum > m){
                sum -= materials[endIndex];
                endIndex -= 1;
                sum += materials[endIndex];
            }
            else{
                sum -= materials[startIndex];
                startIndex += 1;
                sum += materials[startIndex];
            }
        }

        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

/* 정답코드: 200ms -> 212ms. 더 느려짐;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] materials = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            materials[i] = Integer.parseInt(st.nextToken());
        }

        // Logic
        Arrays.sort(materials);
        
        int startIndex = 0;
        int endIndex = n-1;
        int count = 0;
        while(startIndex < endIndex){
            if(materials[startIndex] + materials[endIndex] < m){
                startIndex += 1;
            }
            else if(materials[startIndex] + materials[endIndex] > m){
                endIndex -= 1;
            }
            else{
                count += 1;
                startIndex += 1;
                endIndex -= 1;
            }
        }

        sb.append(count);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */