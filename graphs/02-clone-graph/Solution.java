class Solution {
    public Node cloneGraph(Node source) {
        Map<Node, Node> originalToClone = new HashMap<>();
        return dfs(source, originalToClone);
    }

    private Node dfs(Node node, Map<Node, Node> originalToClone) {
        if (node == null) return null;
        if (originalToClone.containsKey(node)) return originalToClone.get(node);

        Node clone = new Node(node.val);
        originalToClone.put(node, clone);   // write it BEFORE recursing into neighbors!

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, originalToClone));
        }
        return clone;
    }
}
