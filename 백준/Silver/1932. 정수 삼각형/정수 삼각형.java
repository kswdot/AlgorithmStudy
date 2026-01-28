import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] prev = new int[n];
        int[] cur = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int val = Integer.parseInt(st.nextToken());

                if (i == 0 && j == 0) {
                    cur[0] = val;
                } else if (j == 0) {
                    cur[j] = prev[j] + val;              // 왼쪽 끝
                } else if (j == i) {
                    cur[j] = prev[j - 1] + val;          // 오른쪽 끝
                } else {
                    cur[j] = Math.max(prev[j - 1], prev[j]) + val;
                }
            }
            // 다음 줄 준비 (cur -> prev)
            int[] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        int ans = 0;
        for (int x : prev) ans = Math.max(ans, x);
        System.out.println(ans);
    }
}
