import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static StringBuffer sb;
    static int a, b;
    static boolean[] visited;
    static ArrayList<Character> resultArr;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // Logic
            visited = new boolean[10000];
            visited[a] = true;
            resultArr = new ArrayList<>();

            bfs(new Node(a, new ArrayList<>()));
            
            for(char c : resultArr) sb.append(c);
            sb.append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node nowNode = queue.poll();
            int n = nowNode.n;
            //System.out.println(n);
            if(n == b){
                resultArr = nowNode.arr;
                return;
            }

            int n1 = D(n);
            int n2 = S(n);
            int n3 = L(n);
            int n4 = R(n);

            if(!visited[n1]){
                visited[n1] = true;
                ArrayList<Character> arr = new ArrayList<>();
                arr.addAll(nowNode.arr);
                arr.add('D');
                queue.add(new Node(n1, arr));
            }
            if(!visited[n2]){
                visited[n2] = true;
                ArrayList<Character> arr = new ArrayList<>();
                arr.addAll(nowNode.arr);
                arr.add('S');
                queue.add(new Node(n2, arr));
            }
            if(!visited[n3]){
                visited[n3] = true;
                ArrayList<Character> arr = new ArrayList<>();
                arr.addAll(nowNode.arr);
                arr.add('L');
                queue.add(new Node(n3, arr));
            }
            if(!visited[n4]){
                visited[n4] = true;
                ArrayList<Character> arr = new ArrayList<>();
                arr.addAll(nowNode.arr);
                arr.add('R');
                queue.add(new Node(n4, arr));
            }
        }
    }

    static int[] intToArray(int x){
        int[] result = new int[4];

        for(int i=0; i<4; i++){
            result[i] = x%10;
            x /= 10;   
        }

        return result;
    }

    static int arrayToInt(int[] x){
        int result = 0;

        for(int i=0; i<4; i++){
            result += x[i] * Math.pow(10, i);
        }

        return result;
    }

    static int D(int x){
        x <<= 1;
        if(x > 9999) x %= 10000;
        return x;
    }

    static int S(int x){
        if(x == 0) x = 10000;
        x -= 1;
        return x;
    }
    
    static int L(int x){
        int[] arr = intToArray(x);
        int temp = arr[3];

        for(int i=3; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;

        return arrayToInt(arr);        
    }

    static int R(int x){
        int[] arr = intToArray(x);
        int temp = arr[0];

        for(int i=0; i<3; i++){
            arr[i] = arr[i+1];
        }
        arr[3] = temp;

        return arrayToInt(arr);
    }
}

class Node{
    int n;
    ArrayList<Character> arr;

    public Node(int n, ArrayList<Character> arr){
        this.n = n;
        this.arr = arr;
    }
}

/* 정답코드: 11952ms -> 3224ms
 * 1. 굳이 arr로 계산할 필요가 없음
 * 2. 정답을 저장하는 방법. String[10000]으로...
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // Logic
            String[] result = new String[10000];
            boolean[] visited = new boolean[10000];
            
            Queue<Integer> queue = new LinkedList<>();

            visited[a] = true;
            queue.add(a);
            Arrays.fill(result, "");

            while(!queue.isEmpty() && !visited[b]){
                int now = queue.poll();
                int d = (now*2) % 10000;
                int s = (now == 0) ? 9999 : now-1;
                int l = (now%1000) * 10 + now/1000;
                int r = (now%10) * 1000 +  now/10;

                if(!visited[d]){
                    visited[d] = true;
                    queue.add(d);
                    result[d] = result[now]+"D";
                }
                if(!visited[s]){
                    visited[s] = true;
                    queue.add(s);
                    result[s] = result[now]+"S";
                }
                if(!visited[l]){
                    visited[l] = true;
                    queue.add(l);
                    result[l] = result[now]+"L";
                }
                if(!visited[r]){
                    visited[r] = true;
                    queue.add(r);
                    result[r] = result[now]+"R";
                }
            }
            
            sb.append(result[b]).append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */