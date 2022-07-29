class Solution {    
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
        currSum++;
        grid[i][j] = -1;
        int left = helper(grid, i, j-1, currSum);
        int top = helper(grid, i-1, j, left);
        int bottom = helper(grid, i+1, j, top);
        int right = helper(grid, i, j+1, bottom);
        return right;
    }

}