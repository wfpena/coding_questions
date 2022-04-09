class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curMax = 1;
        int curMin = 1;
        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                curMax = 1;
                curMin = 1;
                max = Math.max(nums[i], max);
            } else {
                tmp = curMax*nums[i];
                curMax = Math.max(nums[i], Math.max(curMax*nums[i], curMin*nums[i]));
                curMin = Math.min(nums[i], Math.min(curMin*nums[i], tmp));
                max = Math.max(curMax, max);
            }
            // System.out.println(curMax + " " + curMin + " " + max);
        }
        return max;
    }
}
