import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P1302Bestseller{
    public static void main(String[] args) throws IOException{
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        HashMap<String, Integer> books = new HashMap<>();
        String book;
        int maxBookCount = 1;
        int bookCount;

        for(int i=0; i<n; i++){
            book = br.readLine();
            if(books.containsKey(book)){
                bookCount = books.get(book);
                books.put(book, ++bookCount);
                if(bookCount > maxBookCount) maxBookCount = bookCount;
            }
            else books.put(book, 1);
        }

        // Logic
        ArrayList<String> results = new ArrayList<>();
        for(String b : books.keySet()){
            bookCount = books.get(b);
            if(bookCount == maxBookCount) results.add(b);
        }

        Collections.sort(results);
        sb.append(results.get(0));

        // Output
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}