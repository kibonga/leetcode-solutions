class Solution {
    public static Node<Integer> invertBinaryTree(Node<Integer> tree) {
        invert(tree);
        return tree;
    }

    private static void invert(Node<Integer> node) {
        if (node == null) return;
        invert(node.left);
        invert(node.right);
        Node<Integer> tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
