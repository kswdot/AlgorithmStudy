import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // s의 인덱스가 여는 괄호면 stack.push
            if (c == '(') {
                stack.push(c);
                // s의 인덱스가 닫는 괄호면 스택에 문자열이 있는지 없는지 확인
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.pop() == 'c') {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}