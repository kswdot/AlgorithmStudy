class Solution {
    public int solution(String s) {
        int countO = 0;
        int countX = 0;
        int answer = 0;
        
        char c1 = s.charAt(0);
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (c1 == s.charAt(i)) {
                countO++;
            } else {
                countX++;
            }
            
            if (countO == countX) {
                answer++;
                if (i != s.length() - 1){
                    c1 = s.charAt(i+1);
                }
            }
        }
        
        answer++;
        
        return answer;
    }
}