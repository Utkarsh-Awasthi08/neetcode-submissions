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
        if(head.next == null || head.next.next == null)
        return;

        ListNode head1 = head;
        List<ListNode> list = new ArrayList<>();
        while(head1 != null){
            list.add(head1);
            head1 = head1.next;
        } 

        int i = 0;
        int j = 1;
        int k = list.size() - 1;
        while(j < k){
            list.get(i).next = list.get(k);
            list.get(k).next = list.get(j);

            i++;
            j++;
            k--;
        }
        list.get(k).next = null;
        
    }
}
