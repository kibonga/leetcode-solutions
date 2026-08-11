class Solution {
    int numRows;
    int numCols;
    int numIslands = 0;

    public int numIslands(char[][] grid) {
        numRows = grid.length;
        numCols = grid[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '0') continue;
                bfs(grid, i, j);
                numIslands++;
            }
        }
        return numIslands;
    }

    void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { row, col });
        grid[row][col] = '0';   // mark WHEN ADDING, not when polling

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] neighbor : getNeighbors(grid, node)) {
                if (grid[neighbor[0]][neighbor[1]] == '0') continue;
                queue.add(neighbor);
                grid[neighbor[0]][neighbor[1]] = '0';
            }
        }
    }

    List<int[]> getNeighbors(char[][] grid, int[] node) {
        int[] deltaRows = new int[] { -1, 0, 1, 0 };
        int[] deltaCols = new int[] { 0, 1, 0, -1 };
        List<int[]> neighbors = new ArrayList<>();
        for (int i = 0; i < deltaRows.length; i++) {
            int neighborRow = node[0] + deltaRows[i];
            int neighborCol = node[1] + deltaCols[i];
            if (0 <= neighborRow && neighborRow < numRows &&
                    0 <= neighborCol && neighborCol < numCols && grid[neighborRow][neighborCol] == '1') {
                neighbors.add(new int[] { neighborRow, neighborCol });
            }
        }
        return neighbors;
    }
}
