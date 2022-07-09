class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        return fibHelper(n, dp);
    }
    
    private int fibHelper(int n, int[] dp) {
        if (dp[n] != 0) return dp[n];
        if (n == 0 || n == 1) {
            return n;
        }
        int result = fibHelper(n-1, dp) + fibHelper(n-2, dp);
        dp[n] = result;
        return result;
    }
}