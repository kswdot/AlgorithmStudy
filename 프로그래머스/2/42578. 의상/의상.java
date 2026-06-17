import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // ( 의상 종류 개수 + 1(입지 않는 경우) ) 곱
        // - 1 (아무것도 입지 않는 경우)
        int answer = 1;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}