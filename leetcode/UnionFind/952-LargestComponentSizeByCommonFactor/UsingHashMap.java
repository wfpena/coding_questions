class Solution {

    public int largestComponentSize(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            for (int i = 2; i*i <= num; i++) {
                if (num%i == 0) {
                    union(map, num, i);
                    union(map, num/i, i);
                }
            }
        }
        // map.entrySet().forEach(entry -> {
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // });
        // System.out.println();

        Map<Integer, Integer> count = new HashMap<>();
        int maxSize = 1;
        for (int num : nums) {
            int parent = getParent(map, num);
            count.put(parent, count.getOrDefault(parent, 0) + 1);
            maxSize = Math.max(maxSize, count.get(parent));
        }

        return maxSize;
    }
    
    private void union(Map<Integer, Integer> map, int n1, int n2) {
        int parent1 = getParent(map, n1);
        int parent2 = getParent(map, n2);
        if (parent1 != parent2) {
            map.put(parent1, parent2);
        }
    }
    
    private int getParent(Map<Integer, Integer> map, int num) {
        if (!map.containsKey(num)) {
            map.put(num, num);
            return num;
        }
        int parent = map.get(num);
        if (parent != num) { 
            parent = getParent(map, parent);
            map.put(num, parent);
        }
        return parent;
    }
}