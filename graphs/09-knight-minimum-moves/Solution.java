class Solution {
    private record Coords(int row, int col) {}

    public int getKnightShortestPath(int x, int y) {
        int targetX = Math.abs(x);
        int targetY = Math.abs(y);

        Queue<Coords> queue = new ArrayDeque<>();
        HashSet<Coords> visited = new HashSet<>();
        var start = new Coords(0, 0);
        queue.add(start);
        visited.add(start);

        int movesCount = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                var node = queue.poll();
                if (node.row() == targetX && node.col() == targetY) return movesCount;
                for (var neighbor : getNextMoves(node, visited, targetX, targetY)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
            movesCount++;
        }

        return -1;
    }

    private List<Coords> getNextMoves(Coords node, HashSet<Coords> visited, int targetX, int targetY) {
        int[] deltaRow = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] deltaCol = {-2, -1, 1, 2, 2, 1, -1, -2};

        List<Coords> nextMoves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int row = node.row() + deltaRow[i];
            int col = node.col() + deltaCol[i];
            var current = new Coords(row, col);

            if (row >= -2 && row <= targetX + 2 && col >= -2 && col <= targetY + 2 && !visited.contains(current)) {
                nextMoves.add(current);
            }
        }

        return nextMoves;
    }
}
