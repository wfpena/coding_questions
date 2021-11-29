class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idx1 = 0;
        int idx2 = 0;
        int[] union = new int[nums1.length + nums2.length];
        while (idx1 + idx2 <= nums1.length + nums2.length) {
            // System.out.println(Arrays.toString(union));
            if (idx1 + idx2 == ((nums1.length + nums2.length)/2)+1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (union[idx1+idx2-2] + union[idx1+idx2-1])/2.0;
                } else {
                    return union[idx1+idx2-1];
                }
            }
            if (idx1 >= nums1.length || (idx2 < nums2.length && nums1[idx1] >= nums2[idx2])) {
                union[idx1+idx2] = nums2[idx2];
                idx2++;
            } else {
                union[idx1+idx2] = nums1[idx1];
                idx1++;
            }
        }
        return -1;
    }
}