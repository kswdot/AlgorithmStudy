
import java.util.Scanner;

// 문제: 곱셈 (실버 1)
public class Main {

    static long A, B, C;

    public static void main(String[] args) {
        // (A^B) % C
        // = ((A % C)^B) % C

        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(pow(A, B, C));
    }

    static long pow(long a, long b, long c) {

        if (b == 1) return a % c;

        long half = pow(a, b / 2, c);

        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
            return ((half * half) % c * a) % c;
        }
    }
}
