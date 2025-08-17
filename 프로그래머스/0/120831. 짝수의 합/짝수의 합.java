class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 2; i <= n; i += 2) {
            count += i;
        }
        return count;
    }
}