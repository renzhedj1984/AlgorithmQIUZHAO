public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroIdx] = nums[i];
                if (i != zeroIdx) {
                    nums[i] = 0;
                }
                zeroIdx++;
            }
        }
    }

    public static void main(String[] args) {
        //int[] nums = {0, 0, 1, 0, 1, 0, 0, 12, 17};
        int[] nums = {1,2,3};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(nums);
    }
}
