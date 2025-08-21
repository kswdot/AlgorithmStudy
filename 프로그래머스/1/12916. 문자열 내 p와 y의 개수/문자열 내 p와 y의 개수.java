class Solution {
    boolean solution(String s) {
        int countP = 0;
        int countY = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            
            if (chr == 'p' || chr == 'P') countP++;
            else if (chr == 'y' || chr == 'Y') countY++;
            
        }
        
        return countP == countY;
    }
}