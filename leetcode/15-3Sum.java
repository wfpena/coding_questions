class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        if (nums == null || nums.length < 3) return response;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) return response;
            // System.out.println(nums[i] + " idx: " + i);
            twoSum(nums, response, i+1, nums[i]);
            // while (i < nums.length-1 && nums[i] == nums[i+1]) i++;
        }
        return response;
    }
    
    private void twoSum(int[] nums, List<List<Integer>> response, int idx, int target) {
        int lo = idx;
        int hi = nums.length-1;
        while (lo < hi) {
            if (nums[lo]+nums[hi]+target == 0) {
                response.add(Arrays.asList(target, nums[lo], nums[hi]));
                while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                lo++;
                hi--;
            } else if (nums[lo]+nums[hi]+target > 0) hi--;
            else lo++;
        }
    }
}