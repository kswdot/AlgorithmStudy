class Solution {
    public int solution(String s) {
        // 부호 판별
        char chr = s.charAt(0);
        
        if (chr == '-') {
          String str = s.substring(1);
          return -Integer.parseInt(str);
        } else {
            String str = s.substring(0);
            return Integer.parseInt(str);
        }
        
    }
}