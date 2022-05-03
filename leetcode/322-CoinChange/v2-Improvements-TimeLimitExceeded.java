class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = helper(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int helper(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int currCount = helper(coins, amount - coins[i]);
                if (currCount < Integer.MAX_VALUE) {
                    count = Math.min(1 + currCount, count);
                }
                // count = Math.min(1 + helper(coins, amount - coins[i]), count);
            }
        }
        return count;
    }
}