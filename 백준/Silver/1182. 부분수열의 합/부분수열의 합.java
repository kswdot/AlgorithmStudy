import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제: 부분수열의 합 (실버 2)
public class Main {

    static int n, s, count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // 원소가 n개인 집합에서 부분 집합의 갯수는 2^n-1 (공집합 제외)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정수의 개수
        s = Integer.parseInt(st.nextToken()); // 목표 합

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);

        if (s == 0) count--;

        System.out.println(count);
    }

    // arr의 k번째 원소를 선택할지 말지 결정하는 함수
    static void func(int k, int sum) {
        if (k == n) {
            if (sum == s) count++;
            return;
        }

        func(k + 1, sum + arr[k]); // 포함한 경우
        func(k + 1, sum); // 포함하지 않은 경우
    }
}
