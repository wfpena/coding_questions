class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i]-1 != i) result.add(i+1);
        // }
        // int i = 0;
        // while (nums[i] != i+1) {
        // while (i < nums.length) {
        //     int nextIdx = nums[i]-1;
        //     nums[i] = i+1;
        //     i = nextIdx;
        //     while (i < nums.length && nums[i] == i+1) {
        //         i++;
        //     }
        // }
        // System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])-1]  < 0) continue;
            nums[Math.abs(nums[i])-1] *=-1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i+1);
        }
        // System.out.println(Arrays.toString(nums));
        return result;
    }
}