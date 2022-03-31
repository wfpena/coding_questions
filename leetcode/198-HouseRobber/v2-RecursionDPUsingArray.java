class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] mem = new int[nums.length + 1];
        Arrays.fill(mem, -1);
        return Math.max(robNext(nums, 0, mem), robNext(nums, 1, mem));
    }
    
    private int robNext(int[] nums, int idx, int[] mem) {
        if (idx >= nums.length) return 0;
        if (mem[idx + 1] != -1) return mem[idx + 1];
        int max = nums[idx] + Math.max(robNext(nums, idx + 2, mem), robNext(nums, idx + 3, mem));
        mem[idx + 1] = max;
        return max;
    }
}