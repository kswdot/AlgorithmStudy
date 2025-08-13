class Solution {
    public int solution(String A, String B) {
        int count = 0;
        String sub = A;
        
        for (int i = 0; i < A.length(); i++) {
            if (sub.equals(B)) {
                return count;
            }
            
            
            String str = sub.substring(A.length() - 1);
            sub = str + sub.substring(0, A.length() - 1);
            count++;
        }
        
        return -1;
    }
}