class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int mid = (start+end)/2;
            if (nums[mid]>nums[end]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        if (target >= nums[start] && target <= nums[nums.length-1]) {
            end = nums.length-1;
        } else {
            start = 0;
            end = end-1;
        }
        while (start <= end) {
            int mid = (start+end)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}