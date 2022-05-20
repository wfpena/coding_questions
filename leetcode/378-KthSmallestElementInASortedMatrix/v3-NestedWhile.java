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
            // if (size + pq.size() >= k) break;
            int limit = col;
            while (lin <= col) {
                pq.add(matrix[lin][limit]);
                limit--;
                lin++;
            }
            // if (size + pq.size() >= k) break;
            // throughDiagonal(col, lin, matrix, pq);
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