import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;

        // 큰 숫자부터 비교
        for (int i = n - 1; i >= 0; i--) {
            if (k >= arr[i]) {
                count += k / arr[i];
                k %= arr[i];
            }
        }

        System.out.println(count);
    }
}