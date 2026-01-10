import java.io.*;
import java.util.*;

public class Main {
    static class Doc {
        int idx, p;
        Doc(int idx, int p) { this.idx = idx; this.p = p; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ArrayDeque<Doc> q = new ArrayDeque<>();
            int[] cnt = new int[10]; // priority 1~9

            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                q.addLast(new Doc(i, p));
                cnt[p]++;
            }

            int printed = 0;

            while (!q.isEmpty()) {
                // 현재 존재하는 최대 중요도 찾기
                int max = 9;
                while (max >= 1 && cnt[max] == 0) max--;

                Doc cur = q.pollFirst();

                if (cur.p < max) {
                    q.addLast(cur); // 뒤로 재배치
                } else {
                    // 인쇄
                    printed++;
                    cnt[cur.p]--;
                    if (cur.idx == M) {
                        sb.append(printed).append('\n');
                        break;
                    }
                }
            }
        }

        System.out.print(sb.toString());
    }
}
