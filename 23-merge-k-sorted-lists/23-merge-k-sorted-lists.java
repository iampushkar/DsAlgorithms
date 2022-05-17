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
    public ListNode mergeKLists(ListNode[] lists) {
        int K = lists.length;
        ListNode nodeMerge = null;
        for(int i=0; i<K; i++) {
            ListNode node1 = lists[i];
            nodeMerge = merge(node1, nodeMerge);
        }
        return nodeMerge;
    }
    

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                tail.next = node1;
                node1 = node1.next;
                tail = tail.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
                tail = tail.next;
            }
        }
        if(node1 != null) {
            tail.next = node1;
        }
        if(node2 != null) {
            tail.next = node2;
        }

        return dummy.next;
    }
}