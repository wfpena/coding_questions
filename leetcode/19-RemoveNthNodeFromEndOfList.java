/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ref = new ListNode(0);
        ListNode ref2 = new ListNode(0);
        ref.next = head;
        ref = ref.next;
        ref2.next = ref;
        // ref2 = ref2.next;
        int count = 0;
        while (ref != null) {
            count++;
            if (count > n) {
                ref2 = ref2.next;
            }
            ref = ref.next;
        }
        if (count == n) return head.next;
        ref2.next = ref2.next.next;
        return head;
    }
}