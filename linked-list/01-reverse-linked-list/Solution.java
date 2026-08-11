class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;  // SAVE FRESH, from the CURRENT curr
            curr.next = prev;                // FLIP the pointer
            prev = curr;                     // move prev FORWARD
            curr = nextTemp;                 // move curr FORWARD
        }
        return prev; // NEW head
    }
}
