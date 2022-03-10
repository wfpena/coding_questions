class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] dp = new int[gas.length+1];
        int lastSum = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            lastSum = lastSum+gas[i]-cost[i];
            dp[i+1] = Math.min(lastSum, dp[i]);
        }
        lastSum = 0;
        for (int i = n-1; i >= 0; i--) {
            lastSum = lastSum+gas[i]-cost[i];
            if (lastSum >= -dp[i+1]) return i;
        }
        return -1;
    }
    
}