class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        int minHealth = move(m, n, 0, 0, dungeon, dp);
        return minHealth < 0 ? -minHealth : 1;
        
    }
    
    private int move(int m, int n,int i, int j, int[][] dungeon, int[][] dp) {
        if (i == m-1 && j == n - 1) {
            return dungeon[i][j] -1;
        }
        if (i >= m || j >= n) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int minPath = Math.min(dungeon[i][j] - 1, dungeon[i][j] + Math.max(move(m, n, i+1, j, dungeon, dp), move(m, n, i, j+1, dungeon, dp)));
        dp[i][j] = minPath;
        return minPath;
    }
    
    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
    
    private void printMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

}