class Solution {
    public int solution(int num) {
        long number = num;
        int count = 0;
        
        while (number != 1) {
            number = (number % 2 == 0) ? number / 2 : number * 3 + 1;
            count++;
            
            if (count == 500) return -1;
        }
        return count;
    }
}