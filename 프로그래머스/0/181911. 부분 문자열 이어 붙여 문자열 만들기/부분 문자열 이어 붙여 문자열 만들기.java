class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < parts.length; i++) {
            int n = parts[i][0];
            int m = parts[i][1] + 1;
            
            String result = my_strings[i].substring(n, m);
            sb.append(result);
        }
        
        return sb.toString();
    }
}