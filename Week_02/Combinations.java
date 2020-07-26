package week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode:https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {
    private List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combine(int n, int k) {
        backTrace(n, k, 1, new LinkedList());
        return res;
    }

    private void backTrace(int n, int k, int start, LinkedList<Integer> curr) {
        if (curr.size() == k)
            res.add(new ArrayList(curr));
        for (int i = start; i < n + 1; i++) {
            curr.add(i);
            backTrace(n, k, i + 1, curr);
            curr.removeLast();
        }
    }
}
