import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}