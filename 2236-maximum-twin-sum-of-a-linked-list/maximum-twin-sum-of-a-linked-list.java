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
    public int pairSum(ListNode head) {

        int length = 1;
        ListNode ptr = head;
        while (ptr.next != null) {
            length++;
            ptr = ptr.next;
        }

        int stop = (length / 2) - 1;
        ptr = head;
        for (int i = 0; i <= stop; i++) {
            ptr = ptr.next;
        }

        ListNode ptr2 = reverseList(ptr);
        ptr = head;
        int max1 = Integer.MIN_VALUE;
        while (ptr2 != null) {
            max1 = Math.max(max1, ptr.val + ptr2.val);
            ptr = ptr.next;
            ptr2 = ptr2.next;
        }

        return max1;

    }

    public ListNode reverseList(ListNode head) {

        ListNode curr = head, prev = null, next;

        while (curr != null) {

            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

}