package solved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class P18111Minecraft{
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String lines[] = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int m = Integer.parseInt(lines[1]);
        int b = Integer.parseInt(lines[2]);  // 인벤토리

        int[][] blocks = new int[n][m];
        int totalBlocks = 0;
        for(int i=0; i<n; i++){
            String lines2[] = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                int block = Integer.parseInt(lines2[j]);
                blocks[i][j] = block;
                totalBlocks += block;
            }
        }
        int mostHeight = totalBlocks/(n*m);

        // 로직
        // 브루트 포스 아니였음??? 시간초과 개같내
        int highest = 0;
        int movement;
        int minMovement = Integer.MAX_VALUE;
        int inventory;
        int targetHeight = mostHeight;
        int[][] copiedBlocks = new int[n][m];
        boolean isEnd = false;
        while(true){
            // 원본 블록 배열 복사
            for(int i=0; i<n; i++){
                System.arraycopy(blocks[i], 0, copiedBlocks[i], 0, m);
            }
            movement = 0;  // 움직인 횟수 0으로 초기화
            inventory = b;  // 인벤토리 b로 초기화
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    int block = copiedBlocks[i][j];
                    int gap = block - targetHeight;
                    // 타겟 높이와 같다면 진행
                    if(gap == 0) {}
                    // 타겟 높이보다 낮다면 블럭 추가
                    else if(gap < 0){
                        copiedBlocks[i][j] = targetHeight;
                        if(gap < 0) gap = -gap;
                        movement += gap;
                        inventory -= gap;
                    }
                    // 타겟 높이보다 높다면 블럭 제거
                    else{
                        copiedBlocks[i][j] = targetHeight;
                        if(gap < 0) gap = -gap;
                        movement += gap*2;
                        inventory += gap;
                    }
                }
            }
            // 인벤토리가 음수면 불가능하기 때문에 그 밑의 높이로 설정
            if(inventory < 0){
                if(isEnd){
                    highest = targetHeight-1;
                    movement = minMovement;
                    break;
                }
                targetHeight -= 1;
            }
            // 인벤토리가 0 이상이면 targetHeight에 도달한 것이므로 일단 리턴
            // 바로 위의 높이도 한 번 구해보고 targetHeight보다 더 적은 수라면 당연히
            // 그걸로 가야됨. 하지만 위 높이가 더 많으면 밑의 높이가 답이고
            // 그 위위 높이는 구할 필요도 없음.
            else{
                if(!isEnd){
                    minMovement = movement;
                    targetHeight += 1;
                    isEnd = true;
                }
                else{
                    if(movement <= minMovement){
                        minMovement = movement;
                        targetHeight += 1;
                    }
                    else{
                        highest = targetHeight-1;
                        movement = minMovement;
                        break;
                    }
                } 
            }
        }

        // 출력
        sb.append(movement).append(" ").append(highest);
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}