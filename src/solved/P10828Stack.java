import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P10828Stack{
    // Field
    public static int[] numbers = null;

    // Methods
    public static void push(int x){
        if(numbers == null){
            numbers = new int[]{x};
        }
        else{
            int[] tempNumbers = Arrays.copyOf(numbers, size()+1);
            tempNumbers[size()] = x;
            numbers = tempNumbers;
            tempNumbers = null;
        }
    }
    public static int pop(){
        if(empty() == 0){
            int x = numbers[size()-1];
            int[] tempNumbers = Arrays.copyOf(numbers, size()-1);
            numbers = tempNumbers;
            tempNumbers = null;
            return x;
        }
        else return -1;
    }
    public static int size(){
        try{
            return numbers.length;
        } catch(Exception e){
            return 0;
        }
    }
    public static int empty(){
        return size() == 0 ? 1 : 0;
    }
    public static int top(){
        return empty() == 0 ? numbers[size()-1] : -1;
    }

    public static void main(String[] args) throws IOException{
        // 입력 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        // 로직
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String[] lines = br.readLine().split(" ");
            switch(lines[0]){
                case "push":
                    push(Integer.parseInt(lines[1]));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}