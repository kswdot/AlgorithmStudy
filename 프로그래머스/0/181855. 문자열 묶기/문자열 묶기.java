import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        // Map 선언
        Map<Integer, Integer> map = new HashMap<>();
        
        // 길이가 같은 문자열들끼리 그룹으로 묶기
        for (String str : strArr) {
            int len = str.length();
            if (map.containsKey(len)) {
                map.put(len, map.get(len) + 1);
            } else {
                map.put(len, 1);
            }
        }
        
        int max = 0;
        for (int count : map.values()) {
            if (count > max) {
                max = count;
            }
        }
        
        return max;
    }
}