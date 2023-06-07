import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P6497PowerShortage{
    static StringBuffer sb;
    static int m, n;
    static int[] parent;
    static PriorityQueue<House> pq;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        while(!(m == 0 && n == 0)){
            parent = new int[m];
            for(int i=0; i<m; i++) parent[i] = i;
            pq = new PriorityQueue<>();
    
            int x, y, z;
            int cost = 0;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());
                cost += z;
    
                pq.add(new House(x, y, z));
            }
    
            // Logic
            int turn = 1;
    
            while(turn < m){
                House house = pq.poll();
    
                if(find(house.house1) != find(house.house2)){
                    union(house.house1, house.house2);
                    cost -= house.distance;
                    turn += 1;
                }
            }
            
            sb.append(cost).append("\n");

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
        }

        // Output
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }

    static void union(int h1, int h2){
        h1 = find(h1);
        h2 = find(h2);

        if(h1 != h2) parent[h2] = h1;
    }

    static int find(int h){
        if(h == parent[h]) return h;
        else return parent[h] = find(parent[h]);
    }
}

class House implements Comparable<House>{
    int house1;
    int house2;
    int distance;

    House(int house1, int house2, int distance){
        this.house1 = house1;
        this.house2 = house2;
        this.distance = distance;
    }

    @Override
    public int compareTo(House house){
        return this.distance - house.distance;
    }
}