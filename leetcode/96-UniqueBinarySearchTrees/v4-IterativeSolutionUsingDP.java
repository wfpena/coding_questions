class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // Inside this loop j = the root element and i = n (number of nodes)
                // ** (needs review): Same idea as before. We calculate going from j to i (the current n on the recursive solution)
                // and multiply how many nodes can be made on the left and right. And sum the total do dp[i]
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}