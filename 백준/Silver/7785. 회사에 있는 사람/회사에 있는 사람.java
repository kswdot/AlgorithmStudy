
import java.util.*;
import java.io.*;

// 문제: 회사에 있는 사람 (실버 5)
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, String> map = new HashMap<>();

        // 각 사람의 이름 + 출/퇴근 기록
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String status = sc.next();

            map.put(name, status);
        }

        List<String> list = new ArrayList<>();

        for (String str : map.keySet()) {
            if (map.get(str).equals("enter")) {
                list.add(str);
            }
        }

        list.sort(Collections.reverseOrder());

        for (String str : list) {
            System.out.println(str);
        }
    }
}
