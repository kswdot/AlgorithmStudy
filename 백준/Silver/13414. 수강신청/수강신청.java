import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); 

        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String studentId = br.readLine();
            
            if (set.contains(studentId)) {
                set.remove(studentId);
            }
            set.add(studentId);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String id : set) {
            sb.append(id).append("\n");
            count++;
            if (count == K) break;
        }

        System.out.print(sb.toString());
    }
}