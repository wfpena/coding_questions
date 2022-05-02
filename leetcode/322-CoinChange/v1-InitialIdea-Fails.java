class Solution {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount);
    }
    
    private int helper(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                count = Math.min(1 + helper(coins, amount - coins[i]), count);
            }
        }
        return count;
    }
}