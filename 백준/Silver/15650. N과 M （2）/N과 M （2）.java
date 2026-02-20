import java.util.Scanner;

// 문제: N과 M (2) (실버 3)
public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        func(0, 1);
    }

    static void func(int x, int y) {
        if (x == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = y; i <= n; i++) {
            arr[x] = i;
            func(x + 1, i + 1);
        }
    }
}
