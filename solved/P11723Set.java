import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class P11723Set{
    public static HashSet<Integer> set = new HashSet<>();

    public static void add(int x){
        set.add(x);
    }
    public static void remove(int x){
        if(set.contains(x)) set.remove(x);
    }
    public static int check(int x){
        if(set.contains(x)) return 1;
        else return 0;
    }
    public static void toggle(int x){
        if(set.contains(x)) set.remove(x);
        else set.add(x);
    }
    public static void all(){
        for(int i=1; i<=20; i++) set.add(i);
    }
    public static void empty(){
        set.clear();
    }

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 로직
        String[] lines;
        for(int i=0; i<n; i++){
            lines = br.readLine().split(" ");
            switch(lines[0]){
                case "add":     add(Integer.parseInt(lines[1])); break;
                case "remove":  remove(Integer.parseInt(lines[1])); break;
                case "check":   sb.append(check(Integer.parseInt(lines[1]))).append("\n"); break;
                case "toggle":  toggle(Integer.parseInt(lines[1])); break;
                case "all":     all(); break;
                case "empty":   empty(); break;
            }
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}