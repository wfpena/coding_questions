class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) return matrix[0][0];
        int n = matrix.length;
        if (k == n*n) return matrix[n-1][n-1];
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int j = (int) Math.ceil((double)(k-1)/n);
        // System.out.println(j);
        int size = ((j+1)*j)/2;
        while (j+1 < 2*n) {
            int col = j;
            int lin = 0;
            if (j+1 >= n) {
                col = n-1;
                lin = j+1-n;
            }
            int min = lin*col + lin + col + 1;
            int max = (lin*n)+(col*n)-(lin*col)+1;
            if (min > k) break;
            int limit = col;
            while (lin <= limit) {
                // System.out.println(min + " " + max);
                pq.add(matrix[lin][col]);
                // if (min <= k && max >= k) {
                //     pq.add(matrix[lin][col]);
                // }
                col--;
                lin++;
                min = lin*col + lin + col + 1;
                max = (lin*n)+(col*n)-(lin*col)+1;
            }
            j++;
        }
        while (pq.size() + size > k) {
            // System.out.println("poll: " + (pq.size() + size) + " " + pq.peek());
            pq.poll();
        }
        // System.out.println("Out: " + pq.size() + " size:" + size + " " + pq.peek());
        return pq.poll();
    }
}