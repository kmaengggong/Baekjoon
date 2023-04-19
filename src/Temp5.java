import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

 public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void depthFirstSearch(int[][] vertexs, int start, int length){
        HashSet<Integer> find = new HashSet<>();
        int n = vertexs.length-1;
        find.add(start);
        int next = start;

        while(find.size() < length){
            for(int i=1; i<=n; i++){
                if(vertexs[next][i] == 1 && !find.contains(i)){
                    next = i;
                    find.add(next);
                    sb.append(next).append(" ");
                    break;
                }
            }
        }
        find.clear();
        find = null;
    }

    public static void breathFirstSearch(int[][] vertexs, int start, int length){
        HashSet<Integer> find = new HashSet<>();
        ArrayList<Integer> nexts = new ArrayList<>();
        int n = vertexs.length-1;
        find.add(start);
        nexts.add(start);

        while(find.size() < length){
            int len = nexts.size();
            for(int x=0; x<len; x++){
                for(int i=1; i<=n; i++){
                    if(vertexs[nexts.get(0)][i] == 1 && !find.contains(i)){
                        find.add(i);
                        nexts.add(i);
                        sb.append(i).append(" ");
                        
                    }
                }
                nexts.remove(0);
            }
        }

        find.clear();
        find = null;
        nexts.clear();
        nexts = null;
    }

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String lines[] = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);  // 정점 갯수
        int m = Integer.parseInt(lines[1]);  // 간선 갯수
        int v = Integer.parseInt(lines[2]);  // 탐색 시작할 번호

        int[][] vertexs = new int[n+1][n+1];
        HashSet<Integer> numbers = new HashSet<>();

        for(int i=0; i<m; i++){
            String[] lines2 = br.readLine().split(" ");
            int x = Integer.parseInt(lines2[0]);
            int y = Integer.parseInt(lines2[1]);
            vertexs[x][y] = 1;
            vertexs[y][x] = 1;
            if(!numbers.contains(x)) numbers.add(x);
            if(!numbers.contains(y)) numbers.add(y);
        }
        int length = numbers.size();
        numbers.clear();
        numbers = null;

        // 로직
        // DFS
        sb.append(v).append(" ");
        depthFirstSearch(vertexs, v, length);
        
        // BPS
        sb.append("\n").append(v).append(" ");
        breathFirstSearch(vertexs, v, length);
    
        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
 }