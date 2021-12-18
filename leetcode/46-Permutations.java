class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        permutation(new ArrayList<Integer>(), nums, response, new boolean[nums.length]);
        return response;
    }
    
    private void permutation(List<Integer> tmp, int[] nums, List<List<Integer>> result, boolean[] read) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!read[i]) {
                tmp.add(nums[i]);
                read[i] = true;
                permutation(tmp, nums, result, read);
                read[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}