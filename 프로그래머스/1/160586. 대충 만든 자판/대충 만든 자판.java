import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 저장 맵
        Map<Character, Integer> minKeys = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int count = i + 1;     
                
                if (!minKeys.containsKey(c) || count < minKeys.get(c)) {
                    minKeys.put(c, count);
                }
            }
        }

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPress = 0;
            boolean canMake = true;

            for (int j = 0; j < target.length(); j++) {
                char targetChar = target.charAt(j);

                if (minKeys.containsKey(targetChar)) {
                    totalPress += minKeys.get(targetChar);
                } else {
                    // 키맵에 없는 문자가 포함된 경우
                    canMake = false;
                    break;
                }
            }

            answer[i] = canMake ? totalPress : -1;
        }

        return answer;
    }
}