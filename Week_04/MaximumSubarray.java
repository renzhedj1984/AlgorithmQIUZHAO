package week4;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        //f[i] = max(f[i-1]+a[i],a[i]) i-1前面所有连续序列的最大值加当前值和当前本身i的值比较
        //f[0] = a[0]
        //f[1] = max(a[0]+a[1],a[1])  [-1,1]=1  [2,8]=10
        if (nums == null) return 0;
        int sum = nums[0];
        int max = sum;
        if (nums.length == 1) return max;
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        //new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        new MaximumSubarray().maxSubArray(new int[]{-2, -1});
    }
}
