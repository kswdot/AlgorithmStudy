class Solution {
    public String solution(String n_str) {
        String answer = "";
        // 반복문으로 n_str의 문자가 0인지 비교
        // 0이 아니라면 answer = n_str.subString(i, n_str.length());
        for (int i = 0; i < n_str.length(); i++) {
            if (n_str.charAt(i) != '0') {
                answer = n_str.substring(i, n_str.length());
                break;
            }
        }
        return answer;
    }
}