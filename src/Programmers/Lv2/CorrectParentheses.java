package Programmers.Lv2;

import java.util.Stack;

public class CorrectParentheses {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
