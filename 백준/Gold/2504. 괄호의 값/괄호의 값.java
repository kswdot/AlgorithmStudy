
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 문제: 괄호의 값 (골드 5)
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Deque<Integer> stack = new ArrayDeque<>();
        boolean ok = true;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '(') {
                stack.push(-1);  // '('
            }
            else if (ch == '[') {
                stack.push(-2);  // '['
            }
            else if (ch == ')') {
                int sum = 0;

                while (!stack.isEmpty() && stack.peek() > 0) {
                    sum += stack.pop();
                }

                if (stack.isEmpty() || stack.peek() != -1) {
                    ok = false;
                    break;
                }

                stack.pop();

                // 값 계산 후 다시 push
                stack.push(sum == 0 ? 2 : 2 * sum);
            }
            else if (ch == ']') {
                int sum = 0;

                while (!stack.isEmpty() && stack.peek() > 0) {
                    sum += stack.pop();
                }

                if (stack.isEmpty() || stack.peek() != -2) {
                    ok = false;
                    break;
                }

                stack.pop();
                stack.push(sum == 0 ? 3 : 3 * sum);
            }
        }

        int result = 0;

        // 남은 값 처리
        while (!stack.isEmpty()) {
            if (stack.peek() < 0) { 
                ok = false;
                break;
            }
            result += stack.pop();
        }

        System.out.println(ok ? result : 0);
    }
}