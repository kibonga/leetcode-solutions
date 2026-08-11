class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // each heap element: {value, row, column}

        for (int row = 0; row < n; row++) {
            heap.offer(new int[]{matrix[row][0], row, 0});  // only the FIRST column of each row, as "list heads"
        }

        int result = -1;
        for (int i = 0; i < k; i++) {
            int[] current = heap.poll();
            result = current[0];
            int row = current[1], col = current[2];
            if (col + 1 < n) {
                heap.offer(new int[]{matrix[row][col + 1], row, col + 1});  // successor from the SAME row
            }
        }

        return result;
    }
}
