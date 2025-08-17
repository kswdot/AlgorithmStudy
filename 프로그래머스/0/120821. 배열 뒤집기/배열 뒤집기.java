class Solution {
    public int[] solution(int[] num_list) {
        int temp = 0;
        
        for (int i = 0; i < num_list.length / 2; i++) {
            temp = num_list[num_list.length - i - 1];
            num_list[num_list.length - i - 1] = num_list[i];
            num_list[i] = temp;
        }
        
        return num_list;
    }
}