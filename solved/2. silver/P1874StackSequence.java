import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.TreeSet;

public class P1874StackSequence{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> targets = new ArrayList<>();
        for(int i=0; i<n; i++){
            targets.add(Integer.parseInt(br.readLine()));
        }

        // 로직
        // 1. 해당 숫자가 나올 때까지 넣다가, 넣은 후 바로 뺌.
        TreeSet<Integer> gotNumbers = new TreeSet<>();
        gotNumbers.addAll(targets);
        ArrayList<Integer> myNumbers = new ArrayList<>();
        ArrayList<Integer> deletes = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        int now = 0;
        int target;
        System.out.println("targets: " + targets);
        System.out.println("-------------------------------------------");
        outer: while(now < n){
            target = targets.get(now);
            System.out.println("target: " + target);
            if(!gotNumbers.isEmpty()){
                Iterator<Integer> itr = gotNumbers.iterator();
                while(itr.hasNext()){
                    int num = itr.next();
                    if(num > target){
                        int number = stack.pop();
                        if(number != target){
                            sb.delete(0, sb.length());
                            sb.append("NO");
                            break outer;
                        }
                        sb.append("-").append("\n");
                        break;
                    }
                    stack.push(num);
                    sb.append("+").append("\n");
                    deletes.add(num);
                    if(num == target) break;
                }
            }
            else{
                int number = stack.pop();
                if(number != target){
                    sb.delete(0, sb.length());
                    sb.append("NO");
                    break outer;
                }
                myNumbers.add(number);
                sb.append("-").append("\n");
            }
            if(!deletes.isEmpty()){
                for(int delete : deletes) gotNumbers.remove(delete);
                deletes.clear();
                int number = stack.pop();
                if(number != target){
                    sb.delete(0, sb.length());
                    sb.append("NO");
                    break outer;
                }
                myNumbers.add(number);
                sb.append("-").append("\n");
            }

            System.out.println("gotNumbers: " + gotNumbers);
            System.out.println("Stack: " + stack);
            System.out.println("myNumbers: " + myNumbers);
            System.out.println("-------------------------------------------");

            now += 1;
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

/* 정답코드: 628ms -> 352ms
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(br.readLine());

        // Logic
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        for(int i=0; i<n; i++){
            int now = a[i];
            if(now >= num){
                while(now >= num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else{
                int out = stack.pop();
                if(out > now){
                    bw.write("NO");
                    result = false;
                    break;
                }
                else{
                    sb.append("-\n");
                }
            }
        }

        // Output
        if(result) bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */