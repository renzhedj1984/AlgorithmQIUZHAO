package week4;

import sun.nio.cs.ext.MacHebrew;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        if (n == 1) return nums[0];
        for (int i = 1; i < n; i++) {
            int _min = Math.min(max * nums[i], Math.min(min * nums[i], nums[i]));
            int _max = Math.max(min * nums[i], Math.max(max * nums[i], nums[i]));
            res = Math.max(res, _max);
            min = _min;
            max = _max;
        }
        return res;
    }

    public int maxProduct2(int[] nums) {
        //与最大子序列和类似，但需要考虑负数乘积会是正整数
        //假设f[i]是0....i数组的最大乘积
        //设定f[i][0]代表最大值,设定f[i][1]代表最小值
        //f[i][0] = max(f[i-1][0]*a[i],f[i-1][1]*a[i],a[i])最小值如果和当前为负数值想乘为最大值
        //f[i][1] = min(f[i-1][1]*a[i],f[i-1][0]*a[i],a[i])最大值如果和当前为负数值想乘为最小值
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = dp[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][1] * nums[i], dp[i - 1][0] * nums[i]), nums[i]);
            res = Math.max(Math.max(dp[i][0], dp[i][1]), res);
        }
        return res;
    }

    public static void main(String[] args) {
        //与最大子序列和类似，但需要考虑负数乘积会是正整数
        //假设f[i]是0....i数组的最大乘积,设定f_max[i]代表最大值,设定f_min[i]代表最小值
        //f_max[i] = max(f_max[i-1]*a[i],f_min[i-1]*a[i],a[i])
        //f_min[i] = min(f_min[i-1]*a[i],f_max[i-1]*a[i],a[i])
        new MaximumProductSubarray().maxProduct2(new int[]{2, 3, -2, -4});
        new MaximumProductSubarray().maxProduct2(new int[]{2, 3, -2, 4});
        //其实也可以通过分治方式进行计算 nums[i]>0 nums[i]=0 nums[i]<0
    }
}
