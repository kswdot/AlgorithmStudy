import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 해시맵 생성
        HashMap<String, Integer> map = new HashMap<>();
        
        // 참가자 목록 => 해시맵 key: 이름, value: 사람의 수
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        // 완주자 목록 => 완주자 목록에 있으면 value - 1
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }
        
        // value의 값이 1 이상이면 출력
        for (int i = 0; i < participant.length; i++) {
            if (map.get(participant[i]) >= 1) {
                answer = participant[i];
                break;
            }
        }
        
        return answer;
    }
}