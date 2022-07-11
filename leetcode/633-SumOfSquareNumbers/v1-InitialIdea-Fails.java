class Solution {
    public boolean judgeSquareSum(int c) {
        // double sq = Math.sqrt(c);
        // double sq2 = Math.sqrt(c-1);
        // if (sq == (int) sq || sq2 == (int) sq2) return true;
        for (int a = 0; a < c; a++) {
            double b = c-Math.pow(a, 2);
            // System.out.println(b);
            if (b == (int) b) return true;
        }
        return false;
    }
}