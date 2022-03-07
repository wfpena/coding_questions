class Solution {
    public int maxProfit(int[] prices) {
        int currBought = prices[0];
        int max = 0;
        for (int i=1; i<prices.length;i++) {
            if (prices[i]<prices[i-1]) {
                max += prices[i-1]-currBought;
                currBought = prices[i];
            } else if (prices[i]<currBought) {
                currBought = prices[i];
            }
        }
        max += prices[prices.length-1]-currBought;
        return max;
    }
}