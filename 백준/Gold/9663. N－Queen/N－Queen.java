import java.util.Scanner;

// 문제: N-Queen (골드 4)
public class Main {

    static int n, count;
    static boolean[] used1, used2, used3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        used1 = new boolean[n]; // 행 전용 => used1[y] => true로
        used2 = new boolean[n * 2]; // 좌측 하단 - 우측 상단 대각선 => used2[x+y] true로
        used3 = new boolean[n * 2]; // 좌측 상단 - 우측 하단 대각선 전용 => used3[x-y+n-1] true로

        func(0);

        System.out.println(count);
    }

    // cur번째 행에 말을 배치할 예정
    static void func(int cur) {
        // func(n)이 호출되면 퀸 n개를 놓는 것에 성공했다는 의미
        if (cur == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used1[i] || used2[cur + i] || used3[cur - i + n - 1]) continue;

            used1[i] = true;
            used2[cur + i] = true;
            used3[cur - i + n - 1] = true;

            func(cur + 1);

            used1[i] = false;
            used2[cur + i] = false;
            used3[cur - i + n - 1] = false;
        }

    }
}
