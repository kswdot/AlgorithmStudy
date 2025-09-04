import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        // 정렬: 문자열 길이 짧은 것부터
        // 정렬: 길이가 같으면 사전순으로
        Arrays.sort(str, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } return a.length() - b.length();
        });


        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0 && str[i].equals(str[i-1])) {
                continue;
            }
            sb.append(str[i]).append("\n");
        }
        System.out.print(sb);
    }
}

