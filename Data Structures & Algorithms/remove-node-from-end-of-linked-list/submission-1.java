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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null)
        return null;
        
        int c = 0;
        ListNode head1 = head;
        while(head1 != null)
        {
            c++;
            head1 = head1.next;
        }
        if(c == n)
        return head.next;

        int s = 0;
        head1 = head;
        ListNode prev = null;
        while(head1 != null)
        {
            s++;
            if(s == c - n + 1)
            {
                prev.next = head1.next;
                return head;
            }
            prev = head1;
            head1 = head1.next;
        }
        return null;
    }
}
