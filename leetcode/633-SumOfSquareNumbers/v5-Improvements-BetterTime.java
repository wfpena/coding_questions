class Solution {
    public boolean judgeSquareSum(int c) {
        double sq = Math.sqrt(c/2);
        // double sq2 = Math.sqrt(c-1);
        // if (sq == (int) sq || sq2 == (int) sq2) return true;
        for (int a = 0; a <= sq; a++) {
            double b = Math.sqrt(c-Math.pow(a, 2));
            // System.out.println(b + " " + Math.pow(a, 2));
            if (b == (int) b) return true;
        }
        return false;
    }
}