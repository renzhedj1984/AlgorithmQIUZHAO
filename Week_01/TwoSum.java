public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (target == (b + a)) {
                    array[0] = i;
                    array[1] = j;
                    break;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        new TwoSum().twoSum(new int[]{4, 5, 89,1,4, 90}, 8);
    }
}
