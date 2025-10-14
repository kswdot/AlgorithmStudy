import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        // key -> 완주한 선수 이름, value -> 이름 개수
        for (String string : completion) {
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }
        
        for (String string : participant) {
            // 만약 값이 0이거나 해시맵에 값이 없으면 답으로 반환
            if (hashMap.getOrDefault(string, 0) == 0) {
                return string;
            }
            
            // 참가한 선수 이름과 비교해서 value -> -1
            hashMap.put(string, hashMap.get(string) - 1);
        }
        
        return null;
    }
}