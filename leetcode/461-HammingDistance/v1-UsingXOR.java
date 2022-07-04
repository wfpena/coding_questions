class Solution {
    public int hammingDistance(int x, int y) {
        // System.out.println(x>>1);
        int xor = x^y;
        int count = 0;
        while (xor > 0) {
            if (xor%2 != 0) count++;
            xor = xor>>1;
        }
        return count;
    }
}