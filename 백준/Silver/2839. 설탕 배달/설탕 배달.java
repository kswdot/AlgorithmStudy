import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        while (true) {
            // 5로 나누어 떨어지는지 먼저 확인
            if (n % 5 == 0) {
                count += n / 5;
                System.out.println(count);
                break;
            }
            
            // 5로 안 나누어지면 봉지 추가
            n -= 3;
            count++;

            if (n < 0) {
                System.out.println("-1");
                break;
            }
        }
    }
}