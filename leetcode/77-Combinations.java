class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, result, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int curr, int n, int k, List<List<Integer>> result, List<Integer> temp) {
        // if (temp.size() == k) {
        if (k == 0) {
            result.add(new ArrayList(temp));
            return;
        }
        for (int i = curr; i <= n-k+1; i++) {
            temp.add(i);
            backtrack(i+1, n, k-1, result, temp);
            temp.remove(temp.size()-1);
        }
    }
}