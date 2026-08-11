class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answers = new ArrayList<>();
        int[] queenColumns = new int[n];

        dfs(answers, queenColumns, 0);

        return answers;
    }

    private void dfs(List<List<String>> answers, int[] queenColumns, int row) {
        int n = queenColumns.length;

        if (row == n) {
            answers.add(buildBoard(queenColumns));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(queenColumns, row, col)) continue;

            queenColumns[row] = col;
            dfs(answers, queenColumns, row + 1);
            // no explicit undo needed - the next iteration/call overwrites queenColumns[row]
        }
    }

    private boolean isValid(int[] queenColumns, int currentRow, int candidateCol) {
        for (int prevRow = 0; prevRow < currentRow; prevRow++) {
            int prevCol = queenColumns[prevRow];
            boolean sameColumn = prevCol == candidateCol;
            boolean sameDiagonal = Math.abs(prevRow - currentRow) == Math.abs(prevCol - candidateCol);
            if (sameColumn || sameDiagonal) return false;
        }
        return true;
    }

    private List<String> buildBoard(int[] queenColumns) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < queenColumns.length; row++) {
            StringBuilder sbRow = new StringBuilder();
            for (int col = 0; col < queenColumns.length; col++) {
                sbRow.append(col == queenColumns[row] ? 'Q' : '.');
            }
            board.add(sbRow.toString());
        }
        return board;
    }
}
