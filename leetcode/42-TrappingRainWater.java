class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 1) return 0;
        int[] maxAhead = new int[height.length+1];
        for (int i = height.length-1; i >= 0; i--) {
            if (maxAhead[i+1] < height[i]) {
                maxAhead[i] = height[i];
            } else maxAhead[i] = maxAhead[i+1];
        }
        int sum = 0;
        int prevMax = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= prevMax) {
                prevMax = height[i];
                continue;
            }
            sum += Math.min(maxAhead[i], prevMax) - height[i];
        }
        return sum;
    }
}