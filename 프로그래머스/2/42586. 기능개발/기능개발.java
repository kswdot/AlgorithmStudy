import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        // 남은 일 수를 담을 배열 객체 생성
        int[] leftDays = new int[progresses.length];
        
        // 남은 일 수 계산해서 배열에 넣기
        for (int i = 0; i < progresses.length; i++) {
            leftDays[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        // 최대 배포일 설정
        // progresses의 첫 번째 인덱스를 배포 가능일로 설정
        int maxDay = leftDays[0];
        int count = 0;
        
        // 배포될 progresses의 개수를 큐에 넣기
        for (int i = 0; i < progresses.length; i++) {
            if (leftDays[i] <= maxDay) {
                count++;
            } else {
                queue.add(count);
                count = 1;
                maxDay = leftDays[i];
            }
        }
        
        queue.add(count);
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}