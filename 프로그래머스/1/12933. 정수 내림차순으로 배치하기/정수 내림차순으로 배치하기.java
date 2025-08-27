import java.util.*;

class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        
        String[] arr = str.split("");
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        String answer = "";
        
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        
        return Long.parseLong(answer);
    }
}