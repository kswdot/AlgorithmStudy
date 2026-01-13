import java.io.*;
import java.util.*;

public class Main {

    static class Tower {
        int idx;
        int h;
        Tower(int idx, int h) {
            this.idx = idx;
            this.h = h;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Tower> stack = new ArrayDeque<>(); // stack처럼 사용

        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peekLast().h <= h) {
                stack.pollLast();
            }

            if (stack.isEmpty()) sb.append(0);
            else sb.append(stack.peekLast().idx);

            if (i < N) sb.append(' ');

            stack.addLast(new Tower(i, h));
        }

        System.out.println(sb.toString());
    }
}
