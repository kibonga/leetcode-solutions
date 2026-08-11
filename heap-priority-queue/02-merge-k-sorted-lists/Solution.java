class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // edge case: empty lists[] or all lists null -> queue stays empty -> return null (head.next), correct with no special-case handling

        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode head = new ListNode(-1);
        ListNode prev = head;

        for (var headNode : lists) {
            if (headNode != null) queue.add(headNode);
        }

        while (!queue.isEmpty()) {
            var current = queue.poll();
            if (current.next != null) queue.add(current.next);
            prev.next = current;   // reuses the EXISTING node directly, doesn't make a copy
            prev = current;
        }

        return head.next;
    }
}
