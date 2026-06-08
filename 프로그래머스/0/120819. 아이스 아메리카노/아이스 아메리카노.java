class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        
        // money: 가지고 있는 돈, 아아 = 5500
        // return: 최대로 마실수 있는 잔 수, 남는 돈
        // 반복문 사용
        for (int i = 1; i <= 200; i++) {
            if (i * 5500 > money) {
                answer[0] = i - 1;
                answer[1] = money - ((i - 1) * 5500);
                break;
            }
        }
        
        return answer;
    }
}