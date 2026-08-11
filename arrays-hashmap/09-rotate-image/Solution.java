class Solution {
    public static List<List<Integer>> rotateImage(List<List<Integer>> matrix) {
        int n = matrix.size();

        // Transpose — only the lower triangle below the diagonal, to avoid double-swapping
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, tmp);
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(i).get(n - j - 1));
                matrix.get(i).set(n - j - 1, tmp);
            }
        }
        return matrix;
    }
}
