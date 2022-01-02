class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        for (int[] row: visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return move(grid, 0, 0, visited, n, m);
    }

    private int move(int[][] grid, int i, int j, int[][] curMin, int n, int m) {
        // int n = grid.length;
        // int m = grid[0].length;
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        if (curMin[i][j] != Integer.MAX_VALUE) {
            return curMin[i][j];
        }
        if (j == m - 1 && i == n - 1) {
            return grid[i][j];
        }
        int left, right, bottom, top;
        bottom = move(grid, i+1, j, curMin, n, m);
        right = move(grid, i, j+1, curMin, n, m);
        int minPath = grid[i][j]+ Math.min(bottom, right);
        curMin[i][j] = minPath;
        return minPath;
    }
    
//     private void printMatrix(int[][] matrix) {
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[i].length; j++) {
//                 System.out.print(matrix[i][j] + " ");
//             }
//             System.out.println();
//         }
//         System.out.println("\n");
//     }
    
//     private void printMatrix(boolean[][] matrix) {
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[i].length; j++) {
//                 System.out.print(matrix[i][j] + " ");
//             }
//             System.out.println();
//         }
//         System.out.println("\n");
//     }
}