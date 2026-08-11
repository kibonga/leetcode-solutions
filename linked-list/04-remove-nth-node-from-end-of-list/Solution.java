class Solution {
    public static Node<Integer> removeNthNodeFromEndOfList(Node<Integer> head, int n) {
        Node<Integer> dummy = new Node<Integer>(-1, head);
        Node<Integer> fast = dummy;
        Node<Integer> slow = dummy;

        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
