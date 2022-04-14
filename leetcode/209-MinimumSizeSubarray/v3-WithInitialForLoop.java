class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int left = 0;
        int curSum = 0;
        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];
        }
        if (curSum<target) return 0;
        
        int minLen = Integer.MAX_VALUE;
        curSum = 0;
        while (right < nums.length) {
            curSum += nums[right++];
            while (curSum >= target) {
                minLen = Math.min(minLen, right-left);
                if (minLen == 1) return minLen;
                curSum -= nums[left++];
            }
            
        }
        if (minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}