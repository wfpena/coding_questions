class Solution {
    public boolean judgeSquareSum(int c) {
        int sqr = (int) Math.sqrt(c);
        for (int a = 0; a<=sqr; a++) {
            double b = Math.sqrt(c-(a*a));
            if (b == (int)b) return true;
            // System.out.println(a);
        }
        return false;
    }
}