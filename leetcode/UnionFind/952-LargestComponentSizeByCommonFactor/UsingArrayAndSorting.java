class Solution {

    public int largestComponentSize(int[] nums) {
        Arrays.sort(nums);
        int[] map = new int[nums[nums.length-1]+1];
        for (int num : nums) {
            for (int i = 2; i*i <= num; i++) {
                if (num%i == 0) {
                    union(map, num, i);
                    union(map, num/i, i);
                }
            }
        }
        // System.out.println(Arrays.toString(map));
        Map<Integer, Integer> count = new HashMap<>();
        int maxSize = 1;
        for (int num : nums) {
            int parent = getParent(map, num);
            count.put(parent, count.getOrDefault(parent, 0) + 1);
            maxSize = Math.max(maxSize, count.get(parent));
        }

        return maxSize;
    }
    
    private void union(int[] map, int n1, int n2) {
        int parent1 = getParent(map, n1);
        int parent2 = getParent(map, n2);
        if (parent1 != parent2) {
            map[parent1] = parent2;
        }
    }
    
    private int getParent(int[] map, int num) {
        if (map[num] == 0) {
            map[num] = num;
            return num;
        }
        if (map[num] != num) {
            map[num] = getParent(map, map[num]);
        }
        return map[num];
    }
}