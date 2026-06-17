import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 앞 작업이 완료될 때까지 뒷 작업은 완료되지 못함
        // 남은 일수 계산해서 저장
        int[] leftDays = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            // 남은 작업량
            int remainProgress = 100 - progresses[i];
            int days = remainProgress / speeds[i];
            
            // 나머지가 있으면 하루 더 필요
            if (remainProgress % speeds[i] != 0) {
                days++;
            }
            
            leftDays[i] = days;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // 첫 번째 작업의 남은 일수를 기준일로
        int maxDay = leftDays[0];
        int count = 1;
        
        // 맨 앞 인덱스와 비교해서 맨 앞 인덱스보다 작거나 같은 값 카운트
        for (int i = 1; i < leftDays.length; i++) {
            if (leftDays[i] <= maxDay) {
                count++;
            } else {
                // 기준일보다 오래 걸릴 경우 끊고 기준일 다시 설정
                list.add(count);
                maxDay = leftDays[i];
                count = 1;
            }
        }
        
        list.add(count);
        
        // 리스트 -> 배열
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}