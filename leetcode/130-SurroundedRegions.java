class Solution {
    
    private void visit(char[][] board, int i, int j, int deltaI) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'D') {
            return;
        }
        board[i][j] = 'D';
        visit(board, i+1, j, deltaI);
        visit(board, i-1, j, deltaI);
        visit(board, i, j-1, deltaI);
        visit(board, i, j+1, deltaI);
    }
    
    public void solve(char[][] board) {
        // printMatrix(board);
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i+=n-1) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0) {
                        visit(board, i, j, 1);
                    } else {
                        visit(board, i, j, -1);
                    }
                }
            }
            if (n-1 == 0) break;
        }
        for (int i = 0; i < m; i+=m-1) {
            for(int j = 0; j < n; j++) {
                if (board[j][i] == 'O') {
                    if (i == 0) {
                        visit(board, j, i, 1);
                    } else {
                        visit(board, j, i, -1);
                    }

                }
            }
            if (m-1 == 0) break;
        }        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }
    
  private void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).forEach((row) -> {
            // System.out.print("[");
            System.out.println(Arrays.toString(row));
            // Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
            // System.out.println("]");
        });
      System.out.println("\n\n");
  }

}