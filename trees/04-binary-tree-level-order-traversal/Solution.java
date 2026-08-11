class Solution {
    public static List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node<Integer> currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            ans.add(currentLevel);
        }

        return result;
    }
}
