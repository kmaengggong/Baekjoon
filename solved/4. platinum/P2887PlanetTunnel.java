import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2887PlanetTunnel{
    static StringBuffer sb;
    static int n;
    static int[] parent;
    static ArrayList<Planet> arr;
    static PriorityQueue<Tunnel> pq;

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        arr = new ArrayList<>();

        StringTokenizer st;
        int x, y, z;

        // 0. 주어진 행성(Planet)을 arr에 저장
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            arr.add(new Planet(i, x, y, z));
        }

        // Logic
        // 1. x, y, z 기준 정렬 정의
        Comparator<Planet> comX = new Comparator<Planet>() {
            @Override
            public int compare(Planet p1, Planet p2){
                if(p1.x == p2.x) return 0;
                else if(p1.x > p2.x) return 1;
                else return -1;
            }
        };
        Comparator<Planet> comY = new Comparator<Planet>() {
            @Override
            public int compare(Planet p1, Planet p2){
                if(p1.y == p2.y) return 0;
                else if(p1.y > p2.y) return 1;
                else return -1;
            }
        };
        Comparator<Planet> comZ = new Comparator<Planet>() {
            @Override
            public int compare(Planet p1, Planet p2){
                if(p1.z == p2.z) return 0;
                else if(p1.z > p2.z) return 1;
                else return -1;
            }
        };

        // 2. 정렬 후 Planet을 계산 해 각 기준의 최소 간선들(Tunnel)로 pq에 저장
        pq = new PriorityQueue<>();

        Collections.sort(arr, comX);
        for(int j=1; j<n; j++){
            pq.add(new Tunnel(arr.get(j).idx, arr.get(j-1).idx, Math.abs(arr.get(j).x - arr.get(j-1).x)));
        }
        Collections.sort(arr, comY);
        for(int j=1; j<n; j++){
            pq.add(new Tunnel(arr.get(j).idx, arr.get(j-1).idx, Math.abs(arr.get(j).y - arr.get(j-1).y)));
        }
        Collections.sort(arr, comZ);
        for(int j=1; j<n; j++){
            pq.add(new Tunnel(arr.get(j).idx, arr.get(j-1).idx, Math.abs(arr.get(j).z - arr.get(j-1).z)));
        }

        // 3. 주어진 간선(Tunner)을 가지고 크루스칼 -> 최소 스패닝 트리
        int result = 0;
        int turn = 1;

        while(turn < n){
            Tunnel tunnel = pq.poll();

            if(find(tunnel.planet1) != find(tunnel.planet2)){
                union(tunnel.planet1, tunnel.planet2);
                result += tunnel.weight;
                turn += 1;
            }
        }

        sb.append(result);

        // Output
        bw.write(sb.toString());
        
        br.close();
        bw.flush();
        bw.close();
    }

    static void union(int a, int b){
        a = parent[a];
        b = parent[b];

        if(a != b) parent[b] = a;
    }

    static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
}

class Planet{
    int idx;
    int x;
    int y;
    int z;

    Planet(int idx, int x, int y, int z){
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Tunnel implements Comparable<Tunnel> {
    int planet1;
    int planet2;
    int weight;

    Tunnel(int planet1, int planet2, int weight){
        this.planet1 = planet1;
        this.planet2 = planet2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Tunnel tunnel){
        return this.weight - tunnel.weight;
    }
}