class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int n : nums) {
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n > second && first != n) {
                third = second;
                second = n;
            } else if (n > third && second != n && first != n) {
                third = n;
            }
        }
        
        return (int)(third == Long.MIN_VALUE ? first : third);
    }
}