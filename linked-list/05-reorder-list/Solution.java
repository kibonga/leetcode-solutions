class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // === Phase 1: Find the middle (slow/fast pointer) ===
        // fast starts at head.next (not head) so slow ends up on the FIRST
        // of the two middle nodes for an even-length list.
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // === Phase 2: Cut into two halves ===
        ListNode secondHalfStart = slow.next;
        slow.next = null;

        // === Phase 3: Reverse the right half (STANDARD pattern — prev starts at null) ===
        ListNode prev = null;
        ListNode curr = secondHalfStart;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        ListNode secondHalfReversed = prev;

        // === Phase 4: Interleave alternately ===
        ListNode p1 = head;
        ListNode p2 = secondHalfReversed;
        while (p2 != null) {
            ListNode p1Next = p1.next;   // save BOTH references before overwriting
            ListNode p2Next = p2.next;

            p1.next = p2;
            p2.next = p1Next;

            p1 = p1Next;
            p2 = p2Next;
        }
    }
}
