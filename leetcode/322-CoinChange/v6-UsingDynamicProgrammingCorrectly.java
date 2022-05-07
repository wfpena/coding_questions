class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int result = helper(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int helper(int[] coins, int amount, int[] dp) {
        if (dp[amount] > 0) return dp[amount];
        if (amount == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount-coins[i] >= 0) {
                int currCount = helper(coins, amount - coins[i], dp);
                if (currCount < Integer.MAX_VALUE) {
                    count = Math.min(1 + currCount, count);
                }
            }
        }
        dp[amount] = count;
        return count;
    }
}