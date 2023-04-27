import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;

public class P1244SwitchTurnOnTurnOff{
    public static LinkedHashMap<Integer, Integer> switches = new LinkedHashMap<>();

    public static void switchMale(int n){
        if(switches.get(n) == 1) switches.replace(n, 0);
        else switches.replace(n, 1);
    }
    public static void switchFemale(int front, int back){
        if(switches.containsKey(front) && switches.containsKey(back)){
            if(switches.get(front) == switches.get(back)){
                switchMale(front);
                switchMale(back);
                switchFemale(front-1, back+1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int s = Integer.parseInt(br.readLine());  // 스위치의 갯수

        // Logic
        String[] lines = br.readLine().split(" ");
        //switches = new int[s];
        for(int i=0; i<s; i++){
            //switches[i] = Integer.parseInt(lines[i]);
            switches.put(i+1, Integer.parseInt(lines[i]));
        }
        
        int n = Integer.parseInt(br.readLine());  // 시행 횟수
        for(int i=0; i<n; i++){
            lines = br.readLine().split(" ");
            int mf = Integer.parseInt(lines[0]);
            int num = Integer.parseInt(lines[1]);

            // 스위치 문제니깐 스위치문 사용
            switch(mf){
                case 1:
                    for(int j=num; j<=s; j+=num) switchMale(j);
                    break;
                case 2:
                    switchMale(num);
                    if(switches.containsKey(num-1) && switches.containsKey(num+1)){
                        if(switches.get(num-1) == switches.get(num+1)){
                            switchFemale(num-1, num+1);
                        }
                    }
                    break;
            }
        }

        int line = 1;
        for(int swit : switches.keySet()){
            if(line == 21){
                sb.append("\n");
                line = 1;
            }
            sb.append(switches.get(swit)).append(" ");
            line += 1;
        }

        // Print
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}