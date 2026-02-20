import java.util.Scanner;

// 문제: N과 M (1) (실버 3)
public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 1~n 자연수
        m = sc.nextInt(); // 길이

        arr = new int[m]; // 수열 배열
        used = new boolean[n + 1]; // 방문 체크 배열

        func(0);
    }

    // arr의 몇 번째 자리를 채우는지 의미
    static void func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;

            arr[k] = i;
            used[i] = true;

            func(k + 1);

            used[i] = false;
        }
    }
}
