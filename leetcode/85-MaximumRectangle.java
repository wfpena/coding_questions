class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1) return 0;
        int n = matrix[0].length;
        int[][] height = new int[matrix.length+1][matrix[0].length+1];
        int[][] left = new int[matrix.length+1][matrix[0].length+1];
        int[][] right = new int[matrix.length+1][matrix[0].length+1];
        int maxArea = 0;
        // int[][] areaMatrix = new int[matrix.length][matrix[0].length];
        for (int[] row: right) {
            Arrays.fill(row, n);
        }

        for (int i = 0; i < matrix.length; i++) {
            int cur_left = 0;
            int cur_right = n;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    height[i+1][j+1] = height[i][j+1] + 1;
                    left[i+1][j+1] = Math.max(left[i][j+1], cur_left);
                } else {
                    cur_left = j+1;
                }
                if (matrix[i][n-j-1] == '1') {
                    right[i+1][n-j] = Math.min(right[i][n-j], cur_right);
                } else {
                    cur_right = n-j-1;
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                maxArea = Math.max(maxArea, (right[i+1][j+1] - left[i+1][j+1])*height[i+1][j+1]);
                // areaMatrix[i][j] = (right[i+1][j+1] - left[i+1][j+1])*height[i+1][j+1];
            }
            // System.out.println("r: " + Arrays.toString(right[i+1]));
            // System.out.println("l: " + Arrays.toString(left[i+1]));
            // System.out.println("h: " + Arrays.toString(height[i+1]));
            // System.out.println("area: " + Arrays.toString(areaMatrix[i]));
        }
        return maxArea;
    }
}