class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while ((x^y) > 0) {
            if ((x^y)%2 != 0) count++;
            x = x>>1;
            y = y>>1;
        }
        return count;
    }
}