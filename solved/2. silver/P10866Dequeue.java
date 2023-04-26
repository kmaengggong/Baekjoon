import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10866Dequeue{
    public static int[] dequeue = null;

    public static void push_front(int x){
        if(dequeue == null){
            dequeue = new int[]{x};
        }
        else{
            int[] tempDequeue = new int[size()+1];
            tempDequeue[0] = x;
            System.arraycopy(dequeue, 0, tempDequeue, 1, size());
            dequeue = tempDequeue;
            tempDequeue = null;
        }
    }
    public static void push_back(int x){
        if(dequeue == null){
            dequeue = new int[]{x};
        }
        else{
            int[] tempDequeue = new int[size()+1];
            tempDequeue[size()] = x;
            System.arraycopy(dequeue, 0, tempDequeue, 0, size());
            dequeue = tempDequeue;
            tempDequeue = null;
        }
    }
    public static int pop_front(){
        if(dequeue == null || size() == 0) return -1;
        int pop = front();
        int[] tempDequeue = new int[size()-1];
        System.arraycopy(dequeue, 1, tempDequeue, 0, size()-1);
        dequeue = tempDequeue;
        tempDequeue = null;
        return pop;
    }
    public static int pop_back(){
        if(dequeue == null || size() == 0) return -1;
        int pop = back();
        int[] tempDequeue = new int[size()-1];
        System.arraycopy(dequeue, 0, tempDequeue, 0, size()-1);
        dequeue = tempDequeue;
        tempDequeue = null;
        return pop;
    }
    public static int size(){
        if(dequeue == null) return 0;
        return dequeue.length;
    }
    public static int empty(){
        if(dequeue == null) return 1;
        return size() == 0 ? 1 : 0;
    }
    public static int front(){
        if(dequeue == null) return -1;
        return size() != 0 ? dequeue[0] : -1;
    }
    public static int back(){
        if(dequeue == null) return -1;
        return size() != 0 ? dequeue[size()-1] : -1;
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
                case "push_front":  push_front(Integer.parseInt(lines[1])); break;
                case "push_back":   push_back(Integer.parseInt(lines[1])); break;
                case "pop_front":   sb.append(pop_front()).append("\n"); break;
                case "pop_back":    sb.append(pop_back()).append("\n"); break;
                case "size":        sb.append(size()).append("\n"); break;
                case "empty":       sb.append(empty()).append("\n"); break;
                case "front":       sb.append(front()).append("\n"); break;
                case "back":        sb.append(back()).append("\n"); break;
            }
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}