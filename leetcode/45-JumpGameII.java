class Solution {
    public int jump(int[] nums) {
        int curEnd = 0;
        int jumps = 0;
        int curFurthest = 0;
        for (int i = 0; i <= nums.length - 2; i++) {
            curFurthest = Math.max(curFurthest, i+nums[i]);
            if (i == curEnd) {
                jumps++;
                if (curFurthest >= nums.length-1) return jumps;
                curEnd = curFurthest;
            }
        }
        return jumps;
    }
}