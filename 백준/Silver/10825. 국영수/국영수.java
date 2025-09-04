import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[][] arr = new String[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
            arr[i][2] = sc.next();
            arr[i][3] = sc.next();
        }

        // 1. return 국어 점수 내림차순
        // 2. if 국어 점수가 같으면 영어 점수 오름차순
        // 3. if 국어/영어 점수가 같으면 수학 내림차순
        // 4. if 모든 점수가 같으면 이름 사전 순으로
        Arrays.sort(arr, (a, b) -> {
           if (a[1].equals(b[1])) {
               if (a[2].equals(b[2])) {
                   if (a[3].equals(b[3])) {
                       return a[0].compareTo(b[0]);
                   }
                   return Integer.parseInt(b[3]) - Integer.parseInt(a[3]);
               }
               return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
           }
            return Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]);
        }
    }
}