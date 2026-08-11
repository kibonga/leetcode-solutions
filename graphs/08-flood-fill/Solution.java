class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startColor = image[sr][sc];
        if (startColor == newColor) return image; // prevents infinite recursion when colors already match

        dfs(image, sr, sc, startColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int startColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] != startColor) return;

        image[r][c] = newColor;
        dfs(image, r + 1, c, startColor, newColor);
        dfs(image, r - 1, c, startColor, newColor);
        dfs(image, r, c + 1, startColor, newColor);
        dfs(image, r, c - 1, startColor, newColor);
    }
}
