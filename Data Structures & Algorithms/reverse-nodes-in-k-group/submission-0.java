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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prevGroupEnd = null;

         while (curr != null) {

            // Find kth node
            ListNode kth = getKthNode(curr, k);

            // Less than k nodes remaining
            if (kth == null) {
                if(prevGroupEnd != null){
                    prevGroupEnd.next = curr;
                }
                break;
            }

            // Save the next group
            ListNode nextGroup = kth.next;

            // Reverse current group
            ListNode newHead = reverse(curr, nextGroup);

            // Connect previous group with current reversed group
            if (prevGroupEnd == null) {
                head = newHead;
            } else {
                prevGroupEnd.next = newHead;
            }

            // curr becomes the end of the reversed group
            prevGroupEnd = curr;

            // Move to next group
            curr = nextGroup;
        }

        return head;
    }

    public ListNode getKthNode(ListNode curr,int k){
        for(int i=0;i<k-1 && curr != null;i++){
            curr = curr.next;
        }
        return curr;
    }
    public ListNode reverse(ListNode curr,ListNode end){
        ListNode prev = null;

        while(curr != end){
            ListNode next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        return prev;

    }
}
