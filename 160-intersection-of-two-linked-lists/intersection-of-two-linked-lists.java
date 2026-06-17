/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       int length1=0;
       int length2=0;
       ListNode temp1=headA;
       while(temp1!=null){
        length1++;
        temp1=temp1.next;  
       } 
       temp1=headA;
       ListNode temp2=headB;
       while(temp2!=null){
       length2++;
        temp2=temp2.next;
       } 
       temp2=headB;
       int diff=Math.abs(length1-length2);
       if(length1>length2){
        for(int i=0;i<diff;i++){
            temp1=temp1.next;
        }
       }else{
        for(int j=0;j<diff;j++){
            temp2=temp2.next;
        }
       }
       while(temp1 !=null && temp2 !=null){
        if(temp1==temp2){
            return temp1;
        }
        temp1=temp1.next;
        temp2=temp2.next;
       }
       return null;

    }
}