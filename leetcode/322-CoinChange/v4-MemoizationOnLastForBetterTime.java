class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = helper(coins, amount, new HashMap<>());
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int helper(int[] coins, int amount, Map<Integer, Integer> dp) {
        if (amount == 0) {
            return 0;
        }
        if (dp.containsKey(amount)) return dp.get(amount);
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int currCount = helper(coins, amount - coins[i], dp);
                if (currCount < Integer.MAX_VALUE) {
                    count = Math.min(1 + currCount, count);
                }
            }
        }
        dp.put(amount, count);
        return count;
    }
}