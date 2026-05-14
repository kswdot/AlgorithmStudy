class Solution {
    public int[] solution(int[] arr) {
        // 배열의 길이가 1인 경우, [-1] 리턴
        if (arr.length <= 1) {
            return new int[]{-1};
        }
        
        // 배열에서 가장 작은 값의 인덱스 찾기
        int minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }
        
        // 최솟값을 제외할 새 배열 생성
        int[] answer = new int[arr.length - 1];
        
        // 최솟값 인덱스만 건너뛰고 새 배열에 값 복사
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == minIdx) {
                continue;
            }
            answer[index++] = arr[i];
        }
        
        return answer;
    }
}