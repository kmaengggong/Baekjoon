import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1436MovieDirectorShhom{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 로직
        int i = 0;
        int number = 0;
        boolean is666 = false;
        String result = null;
        while(i != n){
            String strNumber = String.valueOf(number);
            if(strNumber.contains("6") && strNumber.length() >= 3){
                for(int j=0; j<strNumber.length()-2; j++){
                    if(strNumber.charAt(j) == '6'){
                        if(strNumber.charAt(j+1) == '6'){
                            if(strNumber.charAt(j+2) == '6'){
                                is666 = true;
                                break;
                            }
                        }
                    }
                }
                if(is666){
                    result = strNumber;
                    i += 1;
                }
            }
            is666 = false;
            number += 1;
        }

        // 출력
        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }
}