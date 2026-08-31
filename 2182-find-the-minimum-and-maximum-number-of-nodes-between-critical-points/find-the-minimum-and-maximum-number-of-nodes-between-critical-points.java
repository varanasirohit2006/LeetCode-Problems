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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int arr[] = new int[4];
        Arrays.fill(arr, -1);
        int prev = head.val;
        ListNode ptr = head.next;
        boolean Maxflag = true;
        boolean Minflag = true;
        int countminus = 0;
        int counter = 1;
        int minfromall = Integer.MAX_VALUE;
        int maxfromall = Integer.MIN_VALUE;

        while (ptr.next != null) {
            if (prev < ptr.val && ptr.val > ptr.next.val) {
                if(arr[2] != -1 || arr[3] != -1){
                    minfromall = Math.min(minfromall,Math.min(Math.abs(arr[2] - counter),Math.abs(arr[3] - counter)));
                }
                if (Maxflag == true) {
                    Maxflag = false;
                    arr[0] = counter;
                }
                arr[2] = counter;
            } else if (prev > ptr.val && ptr.val < ptr.next.val) {
                if(arr[2] != -1 || arr[3] != -1){
                    minfromall = Math.min(minfromall,Math.min(Math.abs(arr[2] - counter),Math.abs(arr[3] - counter)));
                }
                if (Minflag == true) {
                    arr[1] = counter;
                    Minflag = false;
                }
                
                arr[3] = counter;
            }
            counter++;
            prev = ptr.val;
            ptr = ptr.next;
        }

        for(int i=0;i<4;i++){
            for(int j=i+1;j<4;j++){
                if((arr[i] == arr[j])|| (arr[i] == -1 || arr[j] == -1)) continue;
                maxfromall = Math.max(maxfromall,Math.abs(arr[i] - arr[j]));
            }
        }

        if(maxfromall == Integer.MIN_VALUE && minfromall == Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }

        return new int[] { minfromall , maxfromall};
    }

    // first max , first min arr[2] arr[3] 
}