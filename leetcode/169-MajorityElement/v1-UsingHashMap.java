class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            if (count > nums.length/2) return n;
            map.put(n, count);
        }
        return -1;
    }
}