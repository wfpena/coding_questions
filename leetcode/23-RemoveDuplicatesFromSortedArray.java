class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int dups = 0;
        int i = 0;
        int last = nums[i];
        i++;
        while (i < nums.length) {
            if (last == nums[i]) {
                dups++;
            } else {
                nums[i - dups] = nums[i];
                last = nums[i - dups];
            }
            i++;
            // System.out.println(Arrays.toString(nums) + " " + i + " " + dups);
        }
        return nums.length - dups;
    }
}