class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[answer.length - i - 1] = Integer.parseInt(str.substring(i, i+1));
        }
        return answer;
    }
}