class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int right = 1;
        int left = 0;
        int prevNum = nums[0];
        int prevNumCount = 1;
        while (right < nums.length) {
            if (nums[right] == prevNum) {
                prevNumCount++;
                if (prevNumCount > 2) {
                    while (right < nums.length && nums[right] == nums[right-1]) right++;
                    if (right >= nums.length) return left+1;
                    prevNumCount = 1;
                }
            } else {
                prevNumCount = 1;
            }
            prevNum = nums[right];
            right++;
            left++;
            nums[left] = prevNum;
        }
        // System.out.println("prevNumCount: " + prevNumCount);
        // System.out.println("left: " + left);
        return left+1;
    }
}