class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), result, 0);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> tmp, List<List<Integer>> result, int idx) {
        result.add(new ArrayList<>(tmp));
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            tmp.add(nums[i]);
            backtrack(nums, tmp, result, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}