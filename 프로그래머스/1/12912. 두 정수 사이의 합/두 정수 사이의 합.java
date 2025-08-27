class Solution {
    public long solution(int a, int b) {
        long count = 0;
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        
        for (int i = start; i <= end; i++) {
            if (start == end) {
                count = start;
            } else {
              count += i;  
            }
        }
        return count;
    }
}