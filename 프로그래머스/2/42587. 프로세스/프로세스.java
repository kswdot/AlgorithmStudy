import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 큐 생성 및 int[현재 위치 인덱스, 중요도 순위] 배열 저장
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }
        
        // 현재 실행 순서 저장 변수
        int order = 0;
        
        // 큐가 빌 때까지 실행
        while (!queue.isEmpty()) {
            // 맨 앞 프로세스 저장 변수
            int[] current = queue.poll();
            // 뒤에 중요도가 더 높은 프로세스가 있는지 저장 변수
            boolean higher = false;
            
            // 뒤에 중요도가 더 높은 프로세스가 있는지 확인
            for (int[] next : queue) {
                if (current[1] < next[1]) {
                    higher = true;
                    break;
                }
            }
            
            // 만약 뒤에 중요도가 더 높은 프로세스가 있다면 큐에 다시 저장
            if (higher) {
                queue.add(current);
            } else {
                // 현재 프로세스가 중요도가 제일 높다면 실행
                order++;
                
                // 변수로 주어진 location과 현재 위치 인덱스가 같다면 해당 순서 반환
                if (location == current[0]) {
                    return order;
                } 
            }
        }
        
        return order;
    }
}