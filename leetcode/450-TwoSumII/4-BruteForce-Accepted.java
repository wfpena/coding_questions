class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i]+nums2[j];
                map.put(sum, 1+map.getOrDefault(sum, 0));
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i]+nums4[j];
                count += map.getOrDefault(-sum, 0);
            }
        }
        return count;
        // return helper(nums1, nums2, nums3, nums4, 0, 0, 0);
    }
    
    private int helper(int[] nums1, int[] nums2, int[] nums3, int[] nums4, int target, int idx, int currCount) {
        // if (idx == 4) return 0;
        int n = nums1.length;
        if (idx == 3) {
            int lastCout = 0;
            for (int i = 0; i < n; i++) {
                // System.out.println("nums4[i]" + nums4[i] + " " + target);
                if (nums4[i]+target == 0) lastCout++;
            }
            return lastCout;
        }
        
        int[] nums = new int[n];
        if (idx == 0) nums = nums1;
        else if (idx == 1) nums = nums2;
        else if (idx == 2) nums = nums3;
        else nums = nums4;
        int count = currCount;
        // System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            // System.out.println(target);
            // max = Math.max(max, helper(nums1, nums2, nums3, nums4, -nums[i]+target, idx+1));
            count += helper(nums1, nums2, nums3, nums4, nums[i]+target, idx+1, currCount);
        }
        return count;
        
    }
}