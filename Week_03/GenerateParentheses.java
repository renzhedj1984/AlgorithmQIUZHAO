package week3;

import java.util.*;

public class GenerateParentheses {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        //recursionAll(2 * n, n, n, new LinkedList());
        divideAndConquer(n, n, new LinkedList<>());
        return res;
    }

    private void recursionAll(int len, int left, int right, LinkedList<Character> chars) {
        if (chars.size() == len) {
            if (valid(chars))
                res.add(toString(chars));
            return;
        }
        if (left > 0) {
            chars.add('(');
            recursionAll(len, left - 1, right, new LinkedList<>(chars));//这里要非常注意的一个问题就是集合对象必须重新初始化
            chars.removeLast();
        }
        if (right > 0) {
            chars.add(')');
            recursionAll(len, left, right - 1, new LinkedList<>(chars));
        }
    }

    private String toString(LinkedList<Character> chars) {
        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean valid(LinkedList<Character> chars) {
        int counter = 0;
        for (Character c : chars) {
            if (c == '(')
                counter++;
            else
                counter--;
            if (counter < 0)
                return false;
        }
        return counter == 0;
    }

    private void divideAndConquer(int left, int right, LinkedList<Character> chars) {
        if (left == 0 && right == 0) {
            res.add(toString(chars));
            return;
        }
        if (left > right) {//左括号必须大于右括号的数量
            return;
        }
        if (left > 0) {
            chars.add('(');
            divideAndConquer(left - 1, right, new LinkedList<>(chars));
            chars.removeLast();
        }
        if (right > 0) {
            chars.add(')');
            divideAndConquer(left, right - 1, new LinkedList<>(chars));
        }
    }

    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(3);
    }
}
