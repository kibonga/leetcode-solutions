class Solution {
    public static boolean hasCycle(Node<Integer> nodes) {
        Node<Integer> fast = nodes;
        Node<Integer> slow = nodes;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;   // "hare" — two steps
            slow = slow.next;         // "tortoise" — one step
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
