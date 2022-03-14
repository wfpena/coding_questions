class Solution {
    public int singleNumber(int[] nums) {
        int xorRes = 0;
        for (int i = 0; i < nums.length; i++) {
            xorRes ^= nums[i];
        }
        return xorRes;
    }
}