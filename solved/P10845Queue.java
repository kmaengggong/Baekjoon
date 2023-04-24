import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10845Queue{
    static int[] queue = null;

    public static void push(int x){
        if(queue == null){
            queue = new int[]{x};
        }
        else{
            int[] tempQueue = new int[size()+1];
            System.arraycopy(queue, 0, tempQueue, 0, size());
            tempQueue[size()] = x;
            queue = tempQueue;
            tempQueue = null;
        }
    }
    public static int pop(){
        if(queue == null || empty() == 1) return -1;
        else{
            int pop = front();
            int[] tempQueue = new int[size()-1];
            System.arraycopy(queue, 1, tempQueue, 0, size()-1);
            queue = tempQueue;
            tempQueue = null;
            return pop;
        }
    }
    public static int size(){
        if(queue == null) return 0;
        return queue.length;
    }
    public static int empty(){
        if(queue == null) return 1;
        return size() == 0 ? 1 : 0;
    }
    public static int front(){
        if(queue == null) return -1;
        return empty() == 0 ? queue[0] : -1;
    }
    public static int back(){
        if(queue == null) return -1;
        return empty() == 0 ? queue[size()-1] : -1;
    }

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        // 로직  
        for(int i=0; i<n; i++){
            String[] lines = br.readLine().split(" ");
            
            switch(lines[0]){
                case "push":    push(Integer.parseInt(lines[1])); break;
                case "pop":     sb.append(pop()).append("\n"); break;
                case "size":    sb.append(size()).append("\n"); break;
                case "empty":   sb.append(empty()).append("\n"); break;
                case "front":   sb.append(front()).append("\n"); break;
                case "back":    sb.append(back()).append("\n"); break;
            }
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}