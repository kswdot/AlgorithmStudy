class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str_list.length; i++) {
            String result = str_list[i].contains(ex) ? "" :  str_list[i];
            sb.append(result);
        }
        
        return sb.toString();
    }
}