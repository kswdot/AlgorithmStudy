class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        // 기본 좌우 이동 횟수의 최댓값은 오른쪽으로 끝까지 가는 것
        int minMove = length - 1;
        
        for (int i = 0; i < length; i++) {
            // 1. 상하 조작 횟수 계산
            char target = name.charAt(i);
            answer += Math.min(target - 'A', 'Z' - target + 1);
            
            // 2. 좌우 이동 최적화를 위해 연속된 'A'의 끝 위치(next) 찾기
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            
            // 경로 1: 그냥 우회전 (minMove 초기값)
            // 경로 2: 우회전했다가 좌회전으로 빽 (i * 2 + length - next)
            // 경로 3: 좌회전 먼저 했다가 우회전으로 빽 ((length - next) * 2 + i)
            minMove = Math.min(minMove, i * 2 + length - next);
            minMove = Math.min(minMove, (length - next) * 2 + i);
        }
        
        // 상하 조작 횟수 + 최적의 좌우 이동 횟수
        return answer + minMove;
    }
}