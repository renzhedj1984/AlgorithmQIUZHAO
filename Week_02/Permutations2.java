package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations2 {
    private List<List<Integer>> res = new ArrayList();

    private int[] nums;

    private boolean[] visted;

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);//是简枝去重复的前提
        this.nums = nums;
        this.visted = new boolean[nums.length];
        backTrace(new LinkedList());
        return res;
    }

    private void backTrace(LinkedList<Integer> curr) {
        if (curr.size() == nums.length)
            res.add(new ArrayList(curr));
        for (int i = 0; i < nums.length; i++) {
            if (!visted[i] && !(i > 0 && nums[i] == nums[i - 1] && !visted[i - 1])) {
                visted[i] = true;
                curr.add(nums[i]);
                backTrace(curr);
                visted[i] = false;
                curr.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        new Permutations2().permute(new int[]{1, 1, 2, 3});
    }
}
