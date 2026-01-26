import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s == null || s.isEmpty()) {
            System.out.println(-1);
            return;
        }

        char[] seq = {'q','u','a','c','k'};
        // progress: 0이면 'q'부터 시작 가능(막 끝났거나 아직 시작 안 함), 1이면 다음 'u', ..., 4이면 다음 'k'
        ArrayList<Integer> ducks = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int needIndex = -1;
            for (int j = 0; j < 5; j++) {
                if (seq[j] == ch) {
                    needIndex = j;
                    break;
                }
            }
            if (needIndex == -1) { // quack 외 문자
                System.out.println(-1);
                return;
            }

            if (ch == 'q') {
                // progress==0인 오리 재사용이 최우선
                int reuse = -1;
                for (int d = 0; d < ducks.size(); d++) {
                    if (ducks.get(d) == 0) {
                        reuse = d;
                        break;
                    }
                }
                if (reuse == -1) {
                    ducks.add(1); // 'q'를 먹었으니 다음은 'u'(index 1)
                } else {
                    ducks.set(reuse, 1);
                }
            } else {
                // 진행 중인 오리 중에서 지금 문자를 필요로 하는 오리를 찾는다.
                int found = -1;
                for (int d = 0; d < ducks.size(); d++) {
                    if (ducks.get(d) == needIndex) {
                        found = d;
                        break;
                    }
                }
                if (found == -1) { // 받을 오리가 없음
                    System.out.println(-1);
                    return;
                }

                int next = needIndex + 1;
                if (next == 5) next = 0; // 'k'까지 끝났으면 다시 'q' 시작 가능 상태로
                ducks.set(found, next);
            }
        }

        // 모두 "quack"을 끝낸 상태여야 함
        for (int p : ducks) {
            if (p != 0) {
                System.out.println(-1);
                return;
            }
        }

        // 최소 오리 수 = 생성된 오리 수
        System.out.println(ducks.size());
    }
}
