class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
        }
        Set<Integer> set =  new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]) || used[i]) continue;
            set.add(nums[i]);
            tmp.add(nums[i]);
            used[i] = true;
            backtrack(result, tmp, nums, used);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}