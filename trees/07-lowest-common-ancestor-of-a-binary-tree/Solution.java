class Solution {
    public static Node<Integer> lca(Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {
        // case 1: node is null
        if (root == null) return null;

        // case 2: node is node1 or node2 (base case, "descendant of itself")
        if (root.equals(node1) || root.equals(node2)) return root;

        Node<Integer> left = lca(root.left, node1, node2);
        Node<Integer> right = lca(root.right, node1, node2);

        // case 3a (Scenario B): both sides non-null, current node is the LCA
        if (left != null && right != null) return root;

        // case 3c (Scenario A): exactly one side non-null, pass it up
        if (left != null) return left;
        if (right != null) return right;

        // case 3b (Scenario C): both sides null
        return null;
    }
}
