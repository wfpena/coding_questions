class Solution {
    public int maxProfit(int[] prices) {
        int maxSum = 0;
        int minBuyIdx = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[minBuyIdx] < prices[i]) {
                maxSum = Math.max(maxSum, prices[i] - prices[minBuyIdx]);
            } else {
                minBuyIdx = i;
            }
        }
        return maxSum;
    }
}