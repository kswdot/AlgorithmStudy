class Solution {
    public int solution(String A, String B) {
        int count = 0;
        String copy = A;
        
        for (int i = 0; i < A.length(); i++) {
            if (copy.equals(B)) {
                return count;
            }
            
            // 맨 마지막 글자
            String last = copy.substring(A.length() - 1);
            // copy = 맨 마지막 글자 + 맨 마지막 글자를 제외한 글자
            copy = last + copy.substring(0, A.length() - 1);
            count++;
        }
        
        return -1;
    }
}