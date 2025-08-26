import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        
        if (list.isEmpty()) {
            list.add(-1);
        }
        
        int[] answer = list.stream().sorted()
                   .mapToInt(Integer::intValue)
                   .toArray();
        return answer;
    }
}