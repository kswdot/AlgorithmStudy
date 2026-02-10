import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();  
        boolean inTag = false; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                result.append(word.reverse());
                word.setLength(0); // word 비우기
                inTag = true;
                result.append(c);
            } else if (c == '>') {
                inTag = false;
                result.append(c);
            } else if (inTag) {
                // 태그 안이라면 그대로 추가
                result.append(c);
            } else {
                if (c == ' ') {
                    result.append(word.reverse());
                    result.append(c);
                    word.setLength(0);
                } else {
                    word.append(c);
                }
            }
        }
        result.append(word.reverse());
        
        System.out.println(result.toString());
    }
}