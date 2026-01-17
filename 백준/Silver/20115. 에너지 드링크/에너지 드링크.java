import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(arr);

        double result = arr[N - 1]; // 가장 큰 값
        for (int i = 0; i < N - 1; i++) {
            result += arr[i] / 2.0;
        }

        System.out.println(result);
    }
}
