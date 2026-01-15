import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cur = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cur[i] = Integer.parseInt(st.nextToken());

        int[] D = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) D[i] = Integer.parseInt(st.nextToken()) - 1; // 0-index

        // K번 역셔플
        for (int t = 0; t < K; t++) {
            int[] prev = new int[N];
            for (int i = 0; i < N; i++) {
                prev[D[i]] = cur[i];
            }
            cur = prev;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(cur[i]);
            if (i + 1 < N) sb.append(' ');
        }
        System.out.println(sb);
    }
}
