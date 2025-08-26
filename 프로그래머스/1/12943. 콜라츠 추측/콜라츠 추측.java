class Solution {
    public int solution(int num) {
        int count = 0;
        long number = num;
        
        while (number != 1) {
           if (number % 2 == 0) {
               number /= 2;
               count++;
            } else {
               number = number * 3 + 1;
               count++;
           }
        }
        
        if (count > 500) {
            return -1;
        }
        return count;
    }
}