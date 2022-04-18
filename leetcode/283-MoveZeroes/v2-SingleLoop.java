class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else if(zeroes != 0) {
                nums[i-zeroes] = nums[i];
                nums[i] = 0;
            }
        }
    }
}