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
        if(head==null || head.next==null){
            return;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prevmiddle=null;
        while(fast!=null && fast.next!=null){
            prevmiddle=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prevmiddle.next=null;
        ListNode prev=null;
        while(slow!=null){
            ListNode forward=slow.next;
            slow.next=prev;
            prev=slow;
            slow=forward;
        }
        ListNode temp1=head;
        ListNode temp2=prev;
        while(temp1!=null && temp2!=null){
            ListNode next1=temp1.next; 
            ListNode next2=temp2.next;
            temp1.next=temp2; 
            if(next1==null){
                break;
            }
            temp2.next=next1;
            temp1=next1; 
            temp2=next2;
        }
    }
}