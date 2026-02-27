import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine().trim());
            if (arr[i] > max) max = arr[i];
        }

        long low = 1;      // 길이는 1부터
        long high = max;   // 가장 긴 랜선 길이까지
        long answer = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long count = 0;
            for (long len : arr) {
                count += (len / mid);
                // count가 너무 커져도 N 이상이면 더 셀 필요 없음(약간의 최적화)
                if (count >= N) break;
            }

            if (count >= N) {      // mid 길이로 N개 이상 만들 수 있음 -> 더 길게 도전
                answer = mid;
                low = mid + 1;
            } else {               // 부족 -> 더 짧게
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}