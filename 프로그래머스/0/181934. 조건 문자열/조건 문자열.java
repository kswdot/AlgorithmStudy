class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        // eq는 =, !
        // ineq는 >, <
        // 조건에 맞으면 1 아니면 0 return
        
        if (ineq.equals(">")) {
            if (eq.equals("=")) {
                return n >= m ? 1 : 0;
            } else {
                return n > m ? 1 : 0;
            }
        } else {
            if (eq.equals("=")) {
                return n <= m ? 1 : 0;
            } else {
                return n < m ? 1 : 0;
            }
        }
    }
}