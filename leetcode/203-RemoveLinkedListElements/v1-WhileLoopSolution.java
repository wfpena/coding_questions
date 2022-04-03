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
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = new ListNode(-1);
        while (head != null && head.val == val) head = head.next;
        curr.next = head;
        while (curr != null) {
            // System.out.println(curr.val);
            if (curr.next != null && curr.next.val == val) {
                // removeNode(curr);
                curr.next = curr.next.next;
            } else curr = curr.next;
        }
        return head;
    }
}