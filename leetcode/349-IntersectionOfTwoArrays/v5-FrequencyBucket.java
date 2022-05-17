class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> set = new ArrayList<>();
        int[] freq = new int[1001];
        for(Integer x : nums1) {
            freq[x]++;
        }
        for(Integer y : nums2) {
            if(freq[y] > 0) {
                set.add(y);
                freq[y]=0;
            }
        }
        int[] res = new int[set.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = set.get(i);
        }
        return res;
    }
}