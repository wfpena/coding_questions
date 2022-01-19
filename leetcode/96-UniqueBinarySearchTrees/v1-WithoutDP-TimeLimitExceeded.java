/* Without using DP it gets error for input 19 (and above) */

class Solution {
    public int numTrees(int n) {
        return helper(n, 1, n);
    }
    
    private int helper(int n, int min, int max) {
        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += helper(n, i+1, max) * helper(n, min, i-1);
        }
        return sum == 0 ? 1 : sum;
    }
}