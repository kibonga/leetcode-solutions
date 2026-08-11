class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, visited, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int wordIndex, int row, int col) {
        if (wordIndex == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
            visited[row][col] ||
            word.charAt(wordIndex) != board[row][col]) {
            return false;
        }

        visited[row][col] = true;

        var found = dfs(board, visited, word, wordIndex + 1, row + 1, col) ||
                    dfs(board, visited, word, wordIndex + 1, row - 1, col) ||
                    dfs(board, visited, word, wordIndex + 1, row, col + 1) ||
                    dfs(board, visited, word, wordIndex + 1, row, col - 1);

        visited[row][col] = false;   // BACKTRACK - mandatory, regardless of found

        return found;
    }
}
