class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int length, int i, int j) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) return false;
        if (board[i][j] == word.charAt(length)) length++;
        else return false;
        if (length == word.length()) return true;
        board[i][j] ^= 256;
        boolean result = backtrack(board, word, length, i+1, j) 
            || backtrack(board, word, length, i-1, j)
            || backtrack(board, word, length, i, j+1)
            || backtrack(board, word, length, i, j-1);
        board[i][j] ^= 256;;
        return result;
    }
}