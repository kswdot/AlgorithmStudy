class Solution {
    public int solution(String myString, String pat) {
        int count = 0;
        for (int i = 0; i <= myString.length(); i++) {
            int found = myString.indexOf(pat, i);
            if (found == i) {
                count++;
            }
        }
        return count;
    }
}