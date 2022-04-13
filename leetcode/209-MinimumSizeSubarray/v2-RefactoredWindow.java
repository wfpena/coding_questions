class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int curSum = 0;
        while (right < nums.length) {
            curSum += nums[right++];
            while (curSum >= target) {
                minLen = Math.min(minLen, right-left);
                // if (minLen == 1) return minLen;
                curSum -= nums[left++];
            }
            
        }
        if (minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}