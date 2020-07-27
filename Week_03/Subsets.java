package week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    private List<List<Integer>> output = new ArrayList();

    private int[] nums;

    public List<List<Integer>> solution1(int[] nums) {
        output.add(new ArrayList<Integer>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr) {{
                    add(num);
                }});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    public List<List<Integer>> solution2(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length + 1; i++) {
            backTrace(i, 0, new LinkedList<Integer>());
        }
        return output;
    }

    public void backTrace(int len, int start, LinkedList linkedList) {
        if (linkedList.size() == len) {
            output.add(new ArrayList(linkedList));
            return;
        }
        for (int i = start; i < this.nums.length; i++) {
            linkedList.add(this.nums[i]);
            backTrace(len, i + 1, linkedList);
            linkedList.removeLast();
        }
    }

    public static void main(String[] args) {
        new Subsets().solution2(new int[]{1, 2, 3});
    }
}
