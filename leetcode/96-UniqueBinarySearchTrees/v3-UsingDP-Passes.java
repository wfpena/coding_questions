class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        return helper(n, dp);
    }
    
    private int helper(int n, int[] dp) {
        if (dp[n] != 0) return dp[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += helper(i-1, dp) * helper(n-i, dp);
        }
        dp[n] = sum;
        return sum;
    }
}