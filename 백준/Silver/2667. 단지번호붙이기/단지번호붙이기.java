import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        grid = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            grid[i] = line.toCharArray();
        }

        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    sizes.add(bfs(i, j));
                }
            }
        }

        Collections.sort(sizes);

        StringBuilder sb = new StringBuilder();
        sb.append(sizes.size()).append('\n');
        for (int size : sizes) sb.append(size).append('\n');

        System.out.print(sb);
    }

    static int bfs(int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        visited[sx][sy] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] != '1') continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                cnt++;
            }
        }

        return cnt;
    }
}
