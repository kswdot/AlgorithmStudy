import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] A, B;

    static void flip3x3(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                A[i][j] = (A[i][j] == '0') ? '1' : '0';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new char[N][M];
        B = new char[N][M];

        for (int i = 0; i < N; i++) A[i] = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) B[i] = br.readLine().toCharArray();

        // 3x3 뒤집기를 못 하는 경우
        if (N < 3 || M < 3) {
            System.out.println(equal());
            return;
        }

        int cnt = 0;
        // 좌상단부터 그리디로 맞추기
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    flip3x3(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(isSame() ? cnt : -1);
    }

    static int equal() {
        return isSame() ? 0 : -1;
    }

    static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }
}
