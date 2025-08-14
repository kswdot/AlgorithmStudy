import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();

        // 1이 될 때까지 기록
        while (true) {
            list.add(n);
            if (n == 1) break;

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
