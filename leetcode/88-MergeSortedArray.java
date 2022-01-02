class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        while (i < m+n) {
            nums1[i] = nums2[i-m];
            i++;
        }
        Arrays.sort(nums1);
    }
}