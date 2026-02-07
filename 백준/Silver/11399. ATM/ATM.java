import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        Arrays.sort(P);

        int totalWaitTime = 0; // 전체 합
        int currentWaitTime = 0; // 각 사람이 기다린 시간

        for (int i = 0; i < N; i++) {
            currentWaitTime += P[i]; // 총 시간
            totalWaitTime += currentWaitTime;
        }

        System.out.println(totalWaitTime);
    }
}