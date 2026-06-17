import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // 처음 값은 중복X
        list.add(arr[0]);
        
        // 중복 비교 -> 값 넣기
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) { 
                list.add(arr[i]);
            }
        }
        
        // 리스트 -> 배열
        int answer[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}