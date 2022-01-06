class Solution {
    public int climbStairs(int n) {
        int[] mem = new int[n+1];
        return helper(n, mem);
    }
    
    private int helper(int n, int[] dp) {
        if (n <= 0) {
            return 0;
        }
        if (dp[n] != 0) return dp[n];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = helper(n - 1, dp) + helper(n - 2, dp);
        dp[n] = res;
        return res;
    }
}