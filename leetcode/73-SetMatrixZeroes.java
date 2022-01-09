class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m-j-1; j++) {
                if (matrix[i][m-j-1] == 0) colSet.add(m-j-1);
                if (matrix[i][j] == 0) colSet.add(j);

                if (!rowSet.contains(i) && (matrix[i][j] == 0 || matrix[i][m-j-1] == 0)) {
                    rowSet.add(i);
                }
            }
        }
        for (int i : rowSet) {
            for (int j = 0; j <= m-j-1; j++) {
                matrix[i][j] = 0;
                matrix[i][m-j-1] = 0;
            }
        }
        
        for (int i : colSet) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = 0;
            }
        }


    }
}