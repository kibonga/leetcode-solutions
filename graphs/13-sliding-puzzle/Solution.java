class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int val : row) sb.append(val);
        }
        String start = sb.toString();
        if (start.equals(target)) return 0;

        // For a flattened 2x3 board (positions 0-5), valid 2D neighbors per position:
        int[][] neighborsByPos = {
            {1, 3}, {0, 2, 4}, {1, 5},
            {0, 4}, {1, 3, 5}, {2, 4}
        };

        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);

        int moves = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String cur = queue.poll();
                int zeroPos = cur.indexOf('0');

                for (int swapPos : neighborsByPos[zeroPos]) {
                    String next = swap(cur, zeroPos, swapPos);
                    if (next.equals(target)) return moves + 1;
                    if (visited.add(next)) queue.add(next);
                }
            }
            moves++;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return new String(chars);
    }
}
