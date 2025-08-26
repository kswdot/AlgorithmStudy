class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int n = s.length() / 2;
        
        if (s.length() % 2 == 0) {
            sb.append(s.charAt(n-1));
            sb.append(s.charAt(n));
        } else {
            sb.append(s.charAt(n));
        }
        
        return sb.toString();
    }
}