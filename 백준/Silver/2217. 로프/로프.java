import java.util.*;
import java.io.*;

// 문제: 로프 (실버 4)
public class Main {

    public static void main(String[] args) {
        // k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때,
        // 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
        // 이 로프들을 이용하여 들어올리 수 있는 물체의 최대 중량을 구하기

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 최대 무게는 가장 약한 로프가 견딜 수 있는 무게
        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int k = n - i; // 사용하는 로프 개수
            int possible = arr[i] * k;
            answer = Math.max(answer, possible);
        }

        System.out.println(answer);
    }
}
