class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        // if (nums.length == 1) return nums[0] == val ? 0 : 1;
        int start = 0;
        int end = nums.length-1;
        while (start<end) {
            while (start<end && nums[end] == val) end--;
            if (nums[start]==val) {
                nums[start]=nums[end];
                nums[end]=val;
            }
            start++;
        }
        return nums[end] == val ? end : end+1;
    }
}