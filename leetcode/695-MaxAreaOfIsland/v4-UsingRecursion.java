class Solution {
//     public int maxAreaOfIsland(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int[][] dp = new int[n+1][m+1];
//         int max = 0;
//         dp[1][1] = grid[0][0];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (i == 0 && j == 0) {
//                     dp[i+1][j+1] = grid[i][j];
//                 }else if (i == 0) {
//                     dp[i+1][j+1] = (dp[i+1][j] * grid[i][j-1]) + grid[i][j];
//                 } else if (j == 0) {
//                     dp[i+1][j+1] = (dp[i][j+1] * grid[i-1][j]) + grid[i][j];
//                 } else if (grid[i-1][j-1] == 0 && grid[i][j] == 0) {
//                     dp[i+1][j+1] = Math.max(dp[i][j+1] * grid[i-1][j] , dp[i+1][j] * grid[i][j-1]);
//                 } else {
//                     dp[i+1][j+1] = dp[i][j+1]
//                         + dp[i+1][j]
//                         // - dp[i][j]
//                         + grid[i][j];
//                     // dp[i+1][j+1] = (dp[i][j+1] * grid[i-1][j]) 
//                     //     + (dp[i+1][j] * grid[i][j-1])
//                     //     // - dp[i][j]
//                     //     + grid[i][j];
//                     if (grid[i][j-1] == 1 && grid[i-1][j] == 1 && grid[i-1][j-1] == 1) {
//                     // if (grid[i-1][j-1] == 1) {
//                         dp[i+1][j+1] -= dp[i][j];
//                     }
//                 }
//                 max = Math.max(dp[i+1][j+1], max);
//                 // if (grid[i][j] == 0) {
//                 //     dp[i+1][j+1]
//                 // }

//             }
//         }
//         printMatrix(dp);
//         return max;
//     }
    
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || grid[i][j] == -1) continue;
                max = Math.max(helper(grid, i, j, 0), max);
            }
        }
        return max;
    }
    
    private int helper(int[][] grid, int i, int j, int currSum) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == 0) return currSum;
        if (grid[i][j] == 1) {
            currSum++;
        } else {
            currSum = 0;
        }
        grid[i][j] = -1;
        // printMatrix(grid);
        // System.out.println(currSum);
        int left = helper(grid, i, j-1, currSum);
        int top = helper(grid, i-1, j, left);
        int bottom = helper(grid, i+1, j, top);
        int right = helper(grid, i, j+1, bottom);
        return right;
    }

}