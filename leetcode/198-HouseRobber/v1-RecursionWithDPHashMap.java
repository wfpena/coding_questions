class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robNext(nums, 0), robNext(nums, 1));
    }
    
    private int robNext(int[] nums, int idx) {
        if (map.containsKey(idx)) return map.get(idx);
        if (idx >= nums.length) return 0;
        int max = nums[idx] + Math.max(robNext(nums, idx + 2), robNext(nums, idx+3));
        map.put(idx, max);
        return max;
    }
}