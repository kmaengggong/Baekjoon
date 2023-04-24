import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2920Scale{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 로직
        // 입력 다 받고 배열 비교하는 것보다 하드코딩이 빠를 거 같음
        String[] lines = br.readLine().split(" ");
        if(Integer.parseInt(lines[0]) == 1){
            if(Integer.parseInt(lines[1]) == 2){
                if(Integer.parseInt(lines[2]) == 3){
                    if(Integer.parseInt(lines[3]) == 4){
                        if(Integer.parseInt(lines[4]) == 5){
                            if(Integer.parseInt(lines[6]) == 7){
                                if(Integer.parseInt(lines[7]) == 8){
                                    sb.append("ascending");
                                }
                                else sb.append("mixed");
                            }
                            else sb.append("mixed");
                        }
                        else sb.append("mixed");
                    }
                    else sb.append("mixed");
                }
                else sb.append("mixed");
            }
            else sb.append("mixed");
        }

        else if(Integer.parseInt(lines[0]) == 8){
            if(Integer.parseInt(lines[1]) == 7){
                if(Integer.parseInt(lines[2]) == 6){
                    if(Integer.parseInt(lines[3]) == 5){
                        if(Integer.parseInt(lines[4]) == 4){
                            if(Integer.parseInt(lines[5]) == 3){
                                if(Integer.parseInt(lines[6]) == 2){
                                    if(Integer.parseInt(lines[6]) == 2){
                                        sb.append("descending");
                                    }
                                    else sb.append("mixed");
                                }
                                else sb.append("mixed");
                            }
                            else sb.append("mixed");
                        }
                        else sb.append("mixed");
                    }
                    else sb.append("mixed");
                }
                else sb.append("mixed");
            }
            else sb.append("mixed");
        }

        else{
            sb.append("mixed");
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}