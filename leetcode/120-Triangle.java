class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(triangle, 0, 0, dp);
    }
    
    private int helper(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        if (row >= triangle.size()) return 0;
        if (dp[row][col] != -1) return dp[row][col];
        dp[row][col] = triangle.get(row).get(col) + Math.min(helper(triangle, row+1, col, dp), helper(triangle, row+1, col+1, dp));
        return dp[row][col];
    }
}