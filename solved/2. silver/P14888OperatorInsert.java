import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14888OperatorInsert{
    static StringBuffer sb;
    static int n, sum;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        visited = new boolean[4][n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] oper = new int[4];
        oper[0] = Integer.parseInt(st.nextToken());
        oper[1] = Integer.parseInt(st.nextToken());
        oper[2] = Integer.parseInt(st.nextToken());
        oper[3] = Integer.parseInt(st.nextToken());

        for(int i=0; i<4; i++){
            for(int j=0; j<n-1; j++){
                visited[i][j] = true;
            }
        }

        for(int i=0; i<oper[0]; i++) visited[0][i] = false;
        for(int i=0; i<oper[1]; i++) visited[1][i] = false;
        for(int i=0; i<oper[2]; i++) visited[2][i] = false;
        for(int i=0; i<oper[3]; i++) visited[3][i] = false;

        // Logic
        for(int i=0; i<4; i++){
            if(!visited[i][0]){
                sum = arr[0];
                dfs(i, 0, 1);
            }
        }

        sb.append(max).append("\n").append(min);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int depth){
        for(int i=0; i<4; i++){
            for(int j=0; j<n-1; j++){
                if(!visited[i][j]){
                    int temp = sum;
                    visited[i][j] = true;
                    
                    operator(i, depth);
                    
                    if(depth >= n-1){
                        if(sum > max) max = sum;
                        if(sum < min) min = sum;
                        sum = temp;
                        visited[i][j] = false;
                        return;
                    }
                    
                    dfs(i, j, depth+1);
                    
                    sum = temp;
                    visited[i][j] = false;
                }
            }
        }
    }

    static void operator(int oper, int depth){
        if(oper == 0) sum += arr[depth];
        else if(oper == 1) sum -= arr[depth];
        else if(oper == 2) sum *= arr[depth];
        else sum /= arr[depth];
    }
}

/* 정답코드: 2100ms -> 128ms
 * visited 불필요
 * result(sum) 값을 그냥 parameter에 넣어서 메모리 희생하고 시간 줄임
 * oper를 2차원 배열이 아닌 1차원으로 풀이 가능
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    static StringBuffer sb;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr, oper;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());
        
        arr = new int[n];
        oper = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++) oper[i] = Integer.parseInt(st.nextToken());

        // Logic
        for(int i=0; i<4; i++){
            if(oper[i] > 0){
                oper[i] -= 1;
                dfs(i, arr[0], 1);
                oper[i] += 1;
            }
        }

        sb.append(max).append("\n").append(min);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int o, int result, int depth){
        if(o == 0) result += arr[depth];
        else if(o == 1) result -= arr[depth];
        else if(o == 2) result *= arr[depth];
        else result /= arr[depth];

        if(depth >= n-1){
            if(result > max) max = result;
            if(result < min) min = result;
            return;
        }

        for(int i=0; i<4; i++){
            if(oper[i] > 0){
                oper[i] -= 1;
                dfs(i, result, depth+1);
                oper[i] += 1;
            }
        }
    }
}
*/