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
    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        while(head != null) {
            ListNode temp = head;
            head = head.next;
            
            temp.next = null;
            temp.next = rev;
            rev = temp;
        }
        
        return rev;
    }
}