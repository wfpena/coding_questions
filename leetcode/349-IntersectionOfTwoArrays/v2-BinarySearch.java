class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) return intersection(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i =0;
        while(i < nums1.length) {
            if(binarySearch(nums2, nums1[i])) {
                set.add(nums1[i]);
            }
            i++;
        }
        int[] res = new int[set.size()];
        int k = 0;
        Integer[] arr = set.stream().toArray(Integer[]::new);
        for(Integer j : arr) {
            res[k++] = j;
        }
        return res;
    }
    
    private boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(nums[mid]==target || nums[start]==target || nums[end]==target) return true;
            if (nums[mid]>target) {
                end=mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}