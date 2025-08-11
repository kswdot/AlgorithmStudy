class Solution {
    public String solution(String my_string, int s, int e) {
        
        StringBuilder sb = new StringBuilder();
        
        String str1 = my_string.substring(0, s);
        String str2 = new StringBuilder(my_string.substring(s, e + 1)).reverse().toString();
        String str3 = my_string.substring(e + 1);
        
        return sb.append(str1).append(str2).append(str3).toString();
        
        
    }
}