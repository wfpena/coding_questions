class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(target, candidates, result, new ArrayList<>(), 0, 0);
        return result;
    }
    
    private void backtrack(int target, int[] candidates, List<List<Integer>> result, List<Integer> temp, int sum, int currIdx) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = currIdx; i < candidates.length; i++) {
            if (candidates[i] > target || sum+candidates[i] > target) continue;
            temp.add(candidates[i]);
            backtrack(target, candidates, result, temp, sum+candidates[i], i);
            temp.remove(temp.size()-1);
        }
    }
}