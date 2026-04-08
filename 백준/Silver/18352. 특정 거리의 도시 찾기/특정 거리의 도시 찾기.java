import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        K = Integer.parseInt(st.nextToken()); // 목표 최단 거리
        X = Integer.parseInt(st.nextToken()); // 시작 도시 번호

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        distance = new int[N + 1];
        Arrays.fill(distance, -1);

        bfs(X);

        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        } else {
            System.out.print(sb);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        distance[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                // 아직 방문하지 않은 도시라면
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}