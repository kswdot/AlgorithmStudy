import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> category = new HashMap<>();
       
       
        for (int i = 0; i < want.length; i++) {
        category.put(want[i], number[i]);
        }
       
        int answer = 0;

        // i + 9 < discount.length => i < discount.length
        for (int i = 0; i < discount.length - 9; i++) {
       
        HashMap<String, Integer> sales = new HashMap<>();
       
        for (int j = i; j < i + 10; j++) {
            sales.put(discount[j], sales.getOrDefault(discount[j], 0) + 1);
        }
       
    if (category.equals(sales))
        answer++;
}
        return answer;
    }
   
}