import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 가지고 갈 수 있는 최대 개수
        int select = nums.length / 2;
        
        // 해시맵 저장
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        
        return Math.min(map.size(), select);
    
    }
}