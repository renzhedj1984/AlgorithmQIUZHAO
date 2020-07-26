package week2;

import java.util.Stack;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        int start = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.empty()) {
                stack.push(chars[i]);
                start = i;
                continue;
            }
            char c = stack.peek();
            if (c != chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
            if (stack.empty()) {
                if ((i - start) == 1) {
                    sb.append("");
                } else {
                    sb.append(s.substring(start + 1, i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("(()())(())(()(()))"));
    }
}
