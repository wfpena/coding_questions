class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = helper(coins, amount, new int[amount+1]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int helper(int[] coins, int amount, int[] dp) {
        if (amount < 0) return Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) return dp[amount];
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int currCount = 1 + helper(coins, amount - coins[i], dp);
            if (currCount >= 0 && currCount < count) {
                count = currCount;
            } 

//             if (amount-coins[i] >= 0) {
//                 int currCount = 1 + helper(coins, amount - coins[i], dp);
//                 if (currCount >= 0 && currCount < count) {
//                     count = currCount;
//                 } 
                
//             }
        }
        dp[amount] = count;
        return dp[amount];
    }
}