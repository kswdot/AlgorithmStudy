class Solution {
    public int solution(String num_str) {
        int answer = 0;
        
        for (int i = 0; i < num_str.length(); i++) {
            char chr = num_str.charAt(i);
            int result = chr - '0';
            answer += result;
        }
        return answer;
    }
}