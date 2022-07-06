class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        while(x != 0 || y != 0){
            if(((x&1) ^ (y&1)) == 1)   // extract the last bit of x and y and XOR them
                res++;                 // if it is equals to 1 then inc the res
            x = x>>1;
            y = y>>1;
        }
        return res;
    }

}