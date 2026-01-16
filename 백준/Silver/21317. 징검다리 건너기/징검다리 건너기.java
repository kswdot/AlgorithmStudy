import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] small = new int[N + 1]; // small[i]: i -> i+1
        int[] big = new int[N + 1];   // big[i]:   i -> i+2

        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            small[i] = Integer.parseInt(st.nextToken());
            big[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine().trim());

        int[][] dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = INF;
            dp[i][1] = INF;
        }

        dp[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            for (int used = 0; used <= 1; used++) {
                // i-1 -> i (small jump)
                dp[i][used] = Math.min(dp[i][used], dp[i - 1][used] + small[i - 1]);

                // i-2 -> i (big jump)
                if (i >= 3) {
                    dp[i][used] = Math.min(dp[i][used], dp[i - 2][used] + big[i - 2]);
                }
            }

            // i-3 -> i (very big jump) only if not used before
            if (i >= 4) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 3][0] + K);
            }
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}
