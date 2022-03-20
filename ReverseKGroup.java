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
class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        
        ListNode curr = head, next = null, prev = null;
        int count = 0;
        
        while( count < k && curr != null) {
            count++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        if (count != k) {
            reverseKGroup(prev, count);
            return head;
        }
            
        
        if (curr != null)
            head.next = reverseKGroup(curr, k);
            
        return prev;
        
    }
}