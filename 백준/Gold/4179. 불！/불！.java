
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 문제: 불! (골드 3)
public class Main {

    static int R, C;
    static char[][] board;
    static int[][] fire;
    static int[][] jihoon;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        fire = new int[R][C];
        jihoon = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        Queue<int[]> fireQ = new ArrayDeque<>();
        Queue<int[]> jihoonQ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                fire[i][j] = -1;
                jihoon[i][j] = -1;
            }
        }

        // 불이 각 칸에 몇 분에 도착하는지 계산 => 다중 시작점
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'F') {
                    fire[i][j] = 0;
                    fireQ.add(new int[]{i, j});
                }
            }
        }

        // 지훈이가 각 칸에 몇분에 도착하는지 계산
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'J') {
                    jihoon[i][j] = 0;
                    jihoonQ.add(new int[]{i, j});
                }
            }
        }

        bfsFire(fireQ);

        if (!bfsJihoon(jihoonQ)) {
            System.out.println("IMPOSSIBLE");
        }
    }

    static boolean bfsJihoon(Queue<int[]> jihoonQ) {
        while (!jihoonQ.isEmpty()) {
            int[] temp = jihoonQ.poll();
            int x = temp[0];
            int y = temp[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    System.out.println(jihoon[x][y] + 1);
                    return true;
                }

                if (board[nx][ny] != '.') continue;

                if (jihoon[nx][ny] != -1) continue;

                if (fire[nx][ny] == -1 || fire[nx][ny] > jihoon[x][y] + 1) {
                    jihoon[nx][ny] = jihoon[x][y] + 1;
                    jihoonQ.add(new int[]{nx, ny});
                }
            }
        }

        return false;
    }

    static void bfsFire(Queue<int[]> fireQ) {

        while (!fireQ.isEmpty()) {
            int[] temp = fireQ.poll();
            int x = temp[0];
            int y = temp[1];


            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                if (board[nx][ny] == '#') continue;

                if (fire[nx][ny] != -1) continue;

                fire[nx][ny] = fire[x][y] + 1;
                fireQ.add(new int[]{nx, ny});
            }
        }
    }
}
