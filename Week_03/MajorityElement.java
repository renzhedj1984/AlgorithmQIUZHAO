package week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/description/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        int limit = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        recursion(0, nums, map);
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > limit)
                res = entry.getKey();
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        if (nums.length == 0) return 0;
        return bt(nums);
    }

    private void recursion(int i, int[] nums, Map<Integer, Integer> map) {
        if (i == nums.length) {
            return;
        }
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        recursion(i + 1, nums, map);
    }

    private int bt(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        new MajorityElement().majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2});
    }
}
