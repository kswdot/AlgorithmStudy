
class Solution {
    public int solution(String myString, String pat) {
        String result = myString.replace("A", "C").replace("B", "A").replace("C", "B");
        
        return result.contains(pat) ? 1 : 0;
    }
}