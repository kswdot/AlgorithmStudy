class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0, j = 0;
        for (String g : goal) {
            if (i < cards1.length && cards1[i].equals(g)) {
                i++;
            } else if (j < cards2.length && cards2[j].equals(g)) {
                j++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
