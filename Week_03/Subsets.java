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

    public List<List<Integer>> solution3(int[] nums) {
        this.nums = nums;
        backTrace2(0, new LinkedList<Integer>());
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

    public void backTrace2(int index, LinkedList<Integer> linkedList) {
        if (index == this.nums.length) {
            output.add(new LinkedList<>(linkedList));
            return;
        }
        backTrace2(index + 1, linkedList);
        linkedList.add(this.nums[index]);
        backTrace2(index + 1, linkedList);
        linkedList.removeLast();//必须要移除否则影响下一层，导致数据长度不正确
    }

    public static void main(String[] args) {
        new Subsets().solution3(new int[]{1, 2, 3});
    }
}
