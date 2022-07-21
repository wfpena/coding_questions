class Solution {
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a*a <= c/2; a++) {
            double b = Math.sqrt(c-(a*a));
            if (b == (int) b) return true;
        }
        return false;
    }
}