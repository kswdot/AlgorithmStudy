import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String[] arr = new String[s.length()];

        // 접미사 판별하기
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.substring(i);
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}