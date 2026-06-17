import java.util.*;

class Solution {
    boolean solution(String s) {
        
        boolean answer = true;
        
        // 스택 선언 및 초기화
        Stack<Character> stack = new Stack<>();
        
        // '(' 라면 스택 쌓기
        // 만약 ')' 이고 스택의 마지막이 '(' 라면 스택 꺼내기
        // s가 끝났는데 스택이 비어있지 않다면 false 반환
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else {
                if (stack.isEmpty() == true) {
                    answer = false;
                }
                else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    answer = false;
                }
            }
        }
        
        if (stack.isEmpty() == false) {
            answer = false;
        }
        
        return answer;
    }
}