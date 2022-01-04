class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<>());
        helper(nums, sets, new ArrayList<>(), 0);
        return sets;
    }
    
    private void helper(int[] nums, List<List<Integer>> sets, List<Integer> tmp, int i) {
        if (i == nums.length) return;
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            sets.add(new ArrayList<>(tmp));
            if (nums.length == j) break;
            helper(nums, sets, tmp, j+1);
            tmp.remove(tmp.size()-1);
        }
    }
}