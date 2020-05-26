/*
* Given a linked list, remove the nth node from the end of list and return its head.
* For example,Given linked list: 1->2->3->4->5, and n = 2.
* After removing the second node from the end, the linked list becomes 1->2->3->5.
* Note: If n is greater than the size of the list, remove the first node of the list.
* Try doing it using constant additional space.
*
* Approach: Calculate total number of nodes in the list by traversing the head two nodes forward at a time and increase the count by 2.
    * After loop ends if the head points to null, then it means that the number of nodes are even, so decrease the count by 1
    * Now, if given n value is greater than or equal to count, then it means that we need to delete head node.
    * else , traverse for count-n times and remove the element and call System.gc() to clear the deleted node from memory.
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
    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode head = A;
        int count = 1;
        while (head != null && head.next != null) {
            head = head.next.next;
            count += 2;
        }
        if (head == null) {
            count--;
        }
        if (B >= count) {
            A = A.next;
            return A;
        }
        ListNode prev = A;
        head = A.next;
        for (int i = 1; i<=count; i++) {
            if (B == count - i) {
                prev.next = head.next;
                head.next = null;
                System.gc();
                break;
            }
            prev = head;
            head = head.next;
        }
        return A;
    }
}
