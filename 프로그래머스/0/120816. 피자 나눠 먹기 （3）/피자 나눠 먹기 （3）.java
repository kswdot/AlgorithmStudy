class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        
        // i: 피자의 개수
        for (int i = 1; i <= 50; i++) {
            if (i * slice >= n) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}