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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        dummy1.next = l1;
        dummy2.next = l2;
        ListNode head = new ListNode(0);
        helper(dummy1, dummy2, 0, head);
        return head.next.next;
    }

    public void helper(ListNode l1, ListNode l2, int carry, ListNode head) {
        if (l1 == null && l2 == null){
            if(carry == 1) {
                ListNode dummy = new ListNode(1);
                head.next = dummy;
                return;
            }else{
                return;
            }
        }
        int a = 0;
        int b = 0;
        if (l1 != null)
            a = l1.val;
        if (l2 != null)
            b = l2.val;
        if (a + b + carry > 9) {
            ListNode dummy = new ListNode((a + b + carry) % 10);
            head.next = dummy;
            if (l1 == null) {
                helper(null, l2.next, 1, dummy);
            } else if (l2 == null) {
                helper(l1.next, null, 1, dummy);
            } else {
                helper(l1.next, l2.next, 1, dummy);
            }

        } else {
            ListNode dummy = new ListNode(a + b + carry);
            head.next = dummy;
            if (l1 == null) {
                helper(null, l2.next, 0, dummy);
            } else if (l2 == null) {
                helper(l1.next, null, 0, dummy);
            } else {
                helper(l1.next, l2.next, 0, dummy);
            }
        }
    }
}