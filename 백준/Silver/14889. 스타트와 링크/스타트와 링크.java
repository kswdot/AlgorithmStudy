import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] picked; // true면 스타트 팀
    static int best = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        S = new int[N][N];
        picked = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0번을 스타트 팀에 고정 (대칭 중복 제거)
        picked[0] = true;
        dfs(1, 1);

        System.out.println(best);
    }

    // idx: 다음에 고려할 사람 번호, cnt: 현재 스타트 팀에 뽑힌 인원 수
    static void dfs(int idx, int cnt) {
        if (cnt == N / 2) {
            best = Math.min(best, calcDiff());
            return;
        }
        if (idx == N) return;

        // 가지치기: 남은 사람을 다 뽑아도 N/2 못 채우면 중단
        if (cnt + (N - idx) < N / 2) return;

        // idx를 스타트 팀에 넣기
        picked[idx] = true;
        dfs(idx + 1, cnt + 1);

        // idx를 링크 팀에 넣기
        picked[idx] = false;
        dfs(idx + 1, cnt);
    }

    static int calcDiff() {
        int start = 0, link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (picked[i] && picked[j]) {
                    start += S[i][j] + S[j][i];
                } else if (!picked[i] && !picked[j]) {
                    link += S[i][j] + S[j][i];
                }
            }
        }
        return Math.abs(start - link);
    }
}
