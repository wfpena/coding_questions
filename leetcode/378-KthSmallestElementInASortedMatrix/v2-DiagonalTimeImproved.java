class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        int j = (int) Math.ceil((double)(k-1)/n);
        int size = ((j+1)*j)/2;
        while (j+1 <= 2*n) {
            int col = j;
            int lin = 0;
            if (j+1 >= n) {
                col = n-1;
                lin = j+1-n;
            }
            throughDiagonal(col, lin, matrix, pq);
            j++;
        }

        while (pq.size() + size > k) {
            // System.out.println((pq.size() + size) + " " + pq.poll());
            pq.poll();
        }
        // System.out.println("Out: " + pq.size() + " size:" + size + " " + pq.peek());
        return pq.poll();
    }
    
    private void throughDiagonal(int j, int i, int[][] matrix, Queue<Integer> pq) {
        int limit = j;
        while (i <= limit) {
            pq.add(matrix[i][j]);
            j--;
            i++;
        }
    }
}