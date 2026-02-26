import java.util.Scanner;

public class Main {
    public static boolean[][] board;
    public static int min = 64;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        board = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                findMinColor(i, j);
            }
        }
        
        System.out.println(min);
    }

    public static void findMinColor(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        boolean color = board[x][y]; 

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (board[i][j] != color) {
                    count++;
                }
                
                // 다음 칸은 색
                color = !color;
            }
            // 줄이 바뀌면 시작 색
            color = !color;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}