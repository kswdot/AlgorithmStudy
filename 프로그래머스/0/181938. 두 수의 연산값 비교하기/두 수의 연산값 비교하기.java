class Solution {
    public int solution(int a, int b) {
        String sum = "" + a + b;
        int mul = 2 * a * b;
        
        if (Integer.parseInt(sum) < mul) {
            return mul;
        } else {
            return Integer.parseInt(sum);
        }
    }
}