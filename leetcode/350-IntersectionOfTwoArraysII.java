class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for (Integer n : nums2) {
            if (map.getOrDefault(n, 0) > 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        int[] resp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resp[i] = list.get(i);
        }
        return resp;
    }
}