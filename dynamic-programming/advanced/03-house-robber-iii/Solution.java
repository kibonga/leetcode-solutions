class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    // returns {maxIfNodeTaken, maxIfNodeNotTaken}
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int takeNode = node.val + left[1] + right[1];   // take THIS node => children MUST NOT be taken
        int skipNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);   // don't take this node => each child independently picks its better scenario

        return new int[]{takeNode, skipNode};
    }
}
