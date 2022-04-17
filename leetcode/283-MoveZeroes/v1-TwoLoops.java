class Solution {
    public void moveZeroes(int[] nums) {
        // int i = 0;
        // while (i < nums.length) {
        //     if (nums[i] == 0) {
        //         zeroes++;
        //     } else if (zeroes != 0) {
        //         nums[i-zeroes] = nums[i];
        //     }
        //     i++;
        // }
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else if (zeroes != 0) {
                nums[i-zeroes] = nums[i];
            }
        }
        
        for (int i = zeroes; i > 0; i--) {
            nums[nums.length-i] = 0;
        }
    }
}