// TreeSet은 무적이고 TreeMap은 신이다
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P7622DoubleEndedQueue{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeSet<Node> set;

        Comparator<Node> com = new Comparator<>() {
            @Override
            public int compare(Node o1, Node o2){
                if(o1.val == o2.val){
                    if(o1.idx > o2.idx) return -1;
                    else if(o1.idx < o2.idx) return 1;
                    else return 0;
                }
                else if(o1.val > o2.val) return 1;
                else return -1;
            }
        };

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            set = new TreeSet<>(com);
            

            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                switch(command){
                    case "I":
                        set.add(new Node(j, Integer.parseInt(st.nextToken())));
                        break;
                    case "D":
                        if(set.isEmpty()){
                            st.nextToken();
                            break;
                        }
                        if(st.nextToken().equals("1")) set.pollLast();
                        else set.pollFirst();
                        break;
                }
            }

            if(set.isEmpty()) sb.append("EMPTY\n");
            else sb.append(set.last().val).append(" ").append(set.first().val).append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

class Node{
    int idx;
    int val;

    public Node(int idx, int val){
        this.idx = idx;
        this.val = val;
    }
}

/* 향상된 코드: 3200ms -> 2816ms
 * TreeSet -> TreeMap
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{
    static StringBuffer sb;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeMap<Integer, Integer> map;

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            

            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                switch(command){
                    case "I":
                        int num = Integer.parseInt(st.nextToken());
                        map.put(num, map.getOrDefault(num, 0)+1);
                        break;
                    case "D":
                        if(map.isEmpty()){
                            st.nextToken();
                            break;
                        }
                        if(st.nextToken().equals("1")){
                            int x = map.get(map.lastKey());
                            if(x > 1) map.put(map.lastKey(), x-1);
                            else map.remove(map.lastKey());
                        }
                        else{
                            int x = map.get(map.firstKey());
                            if(x > 1) map.put(map.firstKey(), x-1);
                            else map.remove(map.firstKey());
                        }
                        break;
                }
            }
            
            if(map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
 */