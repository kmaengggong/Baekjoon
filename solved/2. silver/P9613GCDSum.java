import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P9613GCDSum{
    static ArrayList<Integer> gcds = new ArrayList<>();

    public static int getGreatestCommonDivisor(int a, int b){
        if(a%b == 0) return b;
        else return getGreatestCommonDivisor(b, a%b);
    }

    public static void getAllGcd(int[] nums){
        int len = nums.length;
        for(int i=1; i<len; i++){
            int gcd = getGreatestCommonDivisor(nums[0], nums[i]);
            gcds.add(gcd);
        }

        if(len > 2){
            int[] newNums = new int[len-1];
            System.arraycopy(nums, 1, newNums, 0, len-1);
            getAllGcd(newNums);
        }
    }

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        String[] lines;
        
        // Logic
        for(int i=0; i<t; i++){
            lines = br.readLine().split(" ");
            int n = Integer.parseInt(lines[0]);
            int[] numbers = new int[n];

            for(int j=0; j<n; j++){
                numbers[j] = Integer.parseInt(lines[j+1]);
            }
            getAllGcd(numbers);

            long sum = 0;
            for(int gcd : gcds){
                sum += gcd;
            }
            sb.append(sum).append("\n");
            gcds.clear();
        }
                
        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}