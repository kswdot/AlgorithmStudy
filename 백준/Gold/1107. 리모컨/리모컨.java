import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] broken = new boolean[10];
        for (int i = 0; i < m; i++) {
            broken[sc.nextInt()] = true;
        }

        int minPress = Math.abs(n - 100);

        for (int i = 0; i <= 999999; i++) {
            int len = check(i, broken);
            if (len > 0) {
                int press = Math.abs(i - n);
                minPress = Math.min(minPress, len + press);
            }
        }

        System.out.println(minPress);
    }

    public static int check(int c, boolean[] broken) {
        if (c == 0) {
            return broken[0] ? 0 : 1;
        }
        int len = 0;
        while (c > 0) {
            if (broken[c % 10]) return 0;
            len++;
            c /= 10;
        }
        return len;
    }
}