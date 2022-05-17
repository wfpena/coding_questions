class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int start = 0;
        int end = 0;
        int count = 0;
        int prevNum = nums[end];
        while (end < nums.length) {
            while (end < nums.length && nums[end] == prevNum) {
                count++;
                end++;
            }
            nums[start] = prevNum;
            start++;
            if (count >= 2) {
                nums[start] = prevNum;
                start++;
            }
            if (end == nums.length) return start;
            count = 0;
            prevNum = nums[end];
        }
        return start;
    }
}
