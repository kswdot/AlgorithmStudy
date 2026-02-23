import java.util.*;
import java.io.*;

// 문제: 숫자 카드 2 (실버 4)
public class Main {

    public static void main(String[] args) throws IOException {
        // 숫자 카드 N, 정수 M
        // 이 수가 적혀있는 숫자 카드를 몇 개 가지고 있는지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(find, 0)).append(' ');
        }

        System.out.print(sb);
    }
}
