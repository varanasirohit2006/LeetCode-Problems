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
    public ListNode deleteMiddle(ListNode head) {
        ListNode ptr = head;
        int length = 0;
        while(ptr!=null){
            length++;
            ptr = ptr.next;
        }
        if(length == 1) return null;
        int steps = (int)Math.floor(length/2);
        ptr = head;
        for(int i=0;i<steps-1;i++){
            ptr = ptr.next;
        }

        ptr.next = ptr.next.next;

        return head;

    }
}