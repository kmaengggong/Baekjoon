import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1991TreeTraversal{
    static StringBuffer sb;
    static int n;
    static List<Integer>[] leftList;
    static List<Integer>[] rightList;
    static char[] alpha = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());
        leftList = new ArrayList[26];
        rightList = new ArrayList[26];

        for(int i=0; i<26; i++){
            leftList[i] = new ArrayList<>();
            rightList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int parent, child1, child2;
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
        
            parent = st.nextToken().toCharArray()[0]-65;
            child1 = st.nextToken().toCharArray()[0]-65;
            child2 = st.nextToken().toCharArray()[0]-65;

            if(child1 > 0) leftList[parent].add(child1);
            if(child2 > 0) rightList[parent].add(child2);
        }

        // Logic
        preorderTraversal(0);
        sb.append("\n");
        inorderTraversal(0);
        sb.append("\n");
        postorderTraversal(0);

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void preorderTraversal(int num){
        sb.append(alpha[num]);

        if(leftList[num].size() > 0) preorderTraversal(leftList[num].get(0));
        if(rightList[num].size() > 0) preorderTraversal(rightList[num].get(0));
    }

    static void inorderTraversal(int num){
        if(leftList[num].size() > 0) inorderTraversal(leftList[num].get(0));
        sb.append(alpha[num]);
        if(rightList[num].size() > 0) inorderTraversal(rightList[num].get(0));
    }

    static void postorderTraversal(int num){
        if(leftList[num].size() > 0) postorderTraversal(leftList[num].get(0));
        if(rightList[num].size() > 0) postorderTraversal(rightList[num].get(0));

        sb.append(alpha[num]);
    }
}