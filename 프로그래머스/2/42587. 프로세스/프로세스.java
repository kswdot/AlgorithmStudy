import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 프로세스 클래스 생성
    class Process {
        int index;    // 위치
        int priority; // 우선순위

        Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        int turn = 0; // 실행 순서

        while (!queue.isEmpty()) {
            Process current = queue.poll(); 
            boolean hasHigherPriority = false;

            
            for (Process p : queue) {
                if (p.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            // 우선 순위가 높으면 뒤로
            if (hasHigherPriority) {
                queue.add(current);
            } else {
                turn++;
                
                if (current.index == location) {
                    return turn;
                }
            }
        }

        return turn;
    }
}