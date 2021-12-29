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
    public ListNode partition(ListNode head, int x) {
        ListNode greater = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        greaterHead.next = greater;
        while (head != null && head.val >= x) {
            greater.next = new ListNode(head.val);
            greater = greater.next;
            head = head.next;
        }
        if (head == null) return greaterHead.next.next;
        ListNode curr = new ListNode(0);
        curr.next = head;
        curr = curr.next;
        ListNode prev = new ListNode(0);
        prev.next = head;
        while (curr != null) {
            if (curr.val >= x) {
                greater.next = new ListNode(curr.val);
                greater = greater.next;
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        prev.next = greaterHead.next.next;
        return head;
    }
}