import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int count = 0;

        int arr[] = new int[num];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

            for (int i = arr.length - 1; i >= 0; i--) {
                if (money >= arr[i]) {
                    count += money / arr[i];
                    money %= arr[i];
                }
        }

        System.out.println(count);
    }
}
