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
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            
            
            if(temp.val != val) {
                tail.next = temp;
                tail = tail.next;
            }
           
        }
        return dummy.next;
    }
}