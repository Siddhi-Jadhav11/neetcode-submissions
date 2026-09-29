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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow ;
        //reverse linked list
        ListNode curr = mid.next;
        ListNode prev = null;
        ListNode next ;
        mid.next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode left = head;
        ListNode right = prev;

        while(left != null && right != null){
            ListNode nextL = left.next;
            ListNode nextR = right.next;

            left.next = right;
            right.next = nextL;

            left = nextL;
            right = nextR;

        }
    }
}
