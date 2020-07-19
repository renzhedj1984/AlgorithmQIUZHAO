public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(0, nums.length - 1, nums);
        swap(0, k - 1, nums);
        swap(k, nums.length - 1, nums);
    }

    private void swap(int start, int end, int[] nums) {
        int m;
        while (start < end) {
            m = nums[start];
            nums[start] = nums[end];
            nums[end] = m;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 4, 55, 5, 19};
        int k = 5;
        new RotateArray().rotate(nums, k);
        System.out.println(nums);
    }
}
