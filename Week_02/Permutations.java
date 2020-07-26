package week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    private List<List<Integer>> res = new ArrayList();

    private int[] nums;

    private boolean[] visted;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.visted = new boolean[nums.length];
        backTrace(new LinkedList());
        return res;
    }

    private void backTrace(LinkedList<Integer> curr) {
        if (curr.size() == nums.length)
            res.add(new ArrayList(curr));
        for (int i = 0; i < nums.length; i++) {
            if (!visted[i]) {
                visted[i] = true;
                curr.add(nums[i]);
                backTrace(curr);
                visted[i] = false;
                curr.removeLast();
            }
        }
    }
}
