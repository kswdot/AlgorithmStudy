class Solution {
    public String[] solution(String[] strings, int n) {
        String temp;
        
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = 0; j < strings.length - 1 - i; j++) {
                char c1 = strings[j].charAt(n);
                char c2 = strings[j+1].charAt(n);
                
                if (c1 > c2) {
                    temp = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = temp;
                } else if (c1 == c2) {
                    if (strings[j].compareTo(strings[j + 1]) > 0) {
                        temp = strings[j];
                        strings[j] = strings[j+1];
                        strings[j+1] = temp;
                    }
                }
            }
        }
        
        return strings;
    }
}