class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        dp[1][1] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }else if (i == 0) {
                    dp[i+1][j+1] = (dp[i+1][j] * grid[i][j-1]) + grid[i][j];
                } else if (j == 0) {
                    dp[i+1][j+1] = (dp[i][j+1] * grid[i-1][j]) + grid[i][j];
                } else {
                    dp[i+1][j+1] = (dp[i][j+1] * grid[i-1][j]) 
                        + (dp[i+1][j] * grid[i][j-1])
                        // - dp[i][j]
                        + grid[i][j];
                    // if (grid[i][j-1] == 1 && grid[i-1][j] == 1 && grid[i-1][j-1] == 1) {
                    if (grid[i-1][j-1] == 1) {
                        dp[i+1][j+1] -= dp[i][j];
                    }
                }
                max = Math.max(dp[i+1][j+1], max);
            }
        }
        // printMatrix(dp);
        return max;
    }
    
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

}