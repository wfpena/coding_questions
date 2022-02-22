class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int right = 1;
        int left = 0;
        int count = 1;
        while (right < nums.length) {
            if (nums[right] == nums[left]) {
                count++;
                if (count == 3) {
                    if (nums[right] == nums[nums.length-1]) return left+1;
                    while (nums[right] == nums[right-1]) right++;
                    count = 1;
                }
            } else {
                count = 1;
            }
            left++;
            if (nums[left] != nums[right]) nums[left] = nums[right];
            right++;
        }
        return left+1;
    }
}