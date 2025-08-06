import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        char[] chr = my_string.toLowerCase().toCharArray();
        
        Arrays.sort(chr);
        
        return new String(chr);
    }
}