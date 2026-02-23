import java.util.*;
import java.io.*;

// 문제: 듣보잡 (실버 4)
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            map1.put(name, 1);
        }

        for (int i = 0; i < m; i++) {
            String name = sc.next();
            map2.put(name, 2);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();

        for (String str : map1.keySet()) {
            if (map2.containsKey(str)) {
                count++;
                list.add(str);
            }
        }

        Collections.sort(list);

        for (String str : list) {
            sb.append(str).append('\n');
        }
        
        System.out.println(count);
        System.out.println(sb);
    }
}
