class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(new int[n+1], 0, result, new boolean[2*n-1], new boolean[2*n-1], new boolean[n]);
        return result;
    }
    
    private void dfs(int[] board, int currCol, List<List<String>> res, boolean[] diagRight, boolean[] diagLeft, boolean[] rows) {
        if (currCol == board.length-1) {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < board.length - 1; i++) {
                StringBuilder row = new StringBuilder(".".repeat(board.length-1));
                row.setCharAt(board[i+1]-1, 'Q');
                list.add(String.valueOf(row));
            }
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < board.length-1; i++) {
            if (board[i+1] == 0 && !diagRight[board.length - (i-currCol) -2] && !diagLeft[i+currCol]) {
                board[i+1] = currCol+1;
                diagRight[board.length - (i-currCol) -2] = true;
                diagLeft[i+currCol] = true;
                dfs(board, currCol+1, res, diagRight, diagLeft, rows);
                diagRight[board.length - (i-currCol) -2] = false;
                diagLeft[i+currCol] = false;
                board[i+1] = 0;
            }
        }
    }
}