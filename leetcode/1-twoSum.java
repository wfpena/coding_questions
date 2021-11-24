class Solution {
    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        if (len == 2) return new int[]{0, 1};
        int k = len -1;
        
        for (int i =0; i < len/2; i++) {
            for (int j = i+1; j < len -i; j++) {
                int needed = target -nums[j];
                if (nums[i] == needed) return new int[]{i, j};
                if (j != k && nums[k] == needed) return new int[]{j, k};
            }
            k--;
        }
        return new int[0];
        
    }
}