class Solution {
    public static int treeMaxDepth(Node<Integer> root) {
        return Math.max(dfs(root, -1), 0);
    }

    private static int dfs(Node<Integer> node, int depth) {
        if (node == null) return depth;
        return Math.max(
            dfs(node.left, depth + 1),
            dfs(node.right, depth + 1)
        );
    }
}
