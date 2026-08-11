class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null) {
                    return depth;
                }
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            depth++;
        }
        return depth;
    }
}
