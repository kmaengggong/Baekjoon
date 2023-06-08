import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1004LittlePrince{
    static StringBuffer sb;
    static Circle[] circles;
    
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            circles = new Circle[n];
            
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                
                circles[j] = new Circle(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                );
            }

            // Logic
            int count = 0;

            for(Circle circle : circles){
                double distance = Math.sqrt(Math.pow((x1-circle.cx), 2) + Math.pow((y1-circle.cy), 2));
                double distance2 = Math.sqrt(Math.pow((x2-circle.cx), 2) + Math.pow((y2-circle.cy), 2));
                if(distance < circle.r && distance2 > circle.r) count += 1;
                if(distance2 < circle.r && distance > circle.r) count += 1;
            }

            sb.append(count).append("\n");
        }

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

class Circle{
    int cx;
    int cy;
    int r;

    public Circle(int cx, int cy, int r){
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }
}