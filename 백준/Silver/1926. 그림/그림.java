
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문제: 그림 (실버 1)
public class Main {

    static int n, m;
    static int[][] board;
    static boolean[][] visited;

    static int count; // 개수
    static int area; // 가장 넓은 그림 넓이

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 세로 크기
        m = Integer.parseInt(st.nextToken()); // 가로 크기

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    count++;
                    int areaSize = bfs(i, j);
                    area = Math.max(area, areaSize);
                }
            }
        }

        sb.append(count).append("\n").append(area);

        System.out.println(sb);
    }

    static int bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();

        visited[sx][sy] = true;
        q.add(new int[]{sx, sy});

        int area = 1;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (visited[nx][ny] || board[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                area++;
            }
        }

        return area;
    }
}
