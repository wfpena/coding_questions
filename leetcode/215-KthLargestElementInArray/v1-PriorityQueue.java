class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int n : nums) {
            pq.add(n);
            
            while (pq.size() > k) pq.poll();
        }

        return pq.poll();
    }
}