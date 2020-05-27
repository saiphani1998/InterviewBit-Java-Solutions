/*
* Given a linked list, swap every two adjacent nodes and return its head.
* For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
* Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*
* */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode head = A.next;
        ListNode prev = null;

        while (A != null && A.next != null) {
            ListNode temp = A.next;
            A.next = A.next.next;
            temp.next = A;

            if (prev != null) prev.next = temp;
            prev = A;

            A = A.next;
        }

        return head;
    }
}
