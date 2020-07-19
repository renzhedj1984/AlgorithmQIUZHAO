public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 2, 2, 2, 6, 6, 7, 8, 9};
        new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        System.out.println(nums);
    }
}
