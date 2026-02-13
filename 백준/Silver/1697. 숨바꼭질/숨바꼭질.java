
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 문제: 숨바꼭질 (실버 1)
public class Main {

    static int N, K;
    static int[] dist; // 방문 체크 및 걸린 시간 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[1000001];

        // 방문 체크 배열 초기화
        for (int i = 0; i <= 100000; i++) {
            dist[i] = -1;
        }

        bfs(N, K);
    }

    static void bfs(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(n);
        dist[n] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();

            if (temp == k) {
                System.out.println(dist[temp]);
                return;
            }

            int[] nextPos = {temp - 1, temp + 1, temp * 2};

            for (int next : nextPos) {
                if (next >= 0 && next <= 100000 && dist[next] == -1) {
                    dist[next] = dist[temp] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
