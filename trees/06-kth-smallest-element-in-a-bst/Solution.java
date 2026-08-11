class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                k--;
                if (k == 0) {
                    return current.val;
                }
                current = current.right;
            }
        }

        return 0; // shouldn't happen with valid input
    }
}
