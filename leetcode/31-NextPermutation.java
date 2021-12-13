class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int idx = -1;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                idx = i-1;
                break;
            }
        }
        if (idx == -1) {
            // Arrays.sort(nums);
            for (int j = 0; j < nums.length/2; j++) {
                swap(nums, j, nums.length-1-j);
            }
            return;
        }
        int right = nums.length-1;
        int left = idx+1;        
        while (left < right) {
            int mid = (left+right)/2;
            if (nums[idx] >= nums[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        if (nums[left] <= nums[idx]) {
            left--;
        }
        swap(nums, left, idx);
        right = nums.length-1;
        idx++;
        while (idx < right) {
            swap(nums, idx, right);
            idx++;
            right--;
        }
        // for (int i = idx+1; i < (nums.length-idx-1)/2; i++) {
        //     swap(nums, i, nums.length-1-i);
        // }
        // Arrays.sort(nums, idx+1, nums.length);
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}