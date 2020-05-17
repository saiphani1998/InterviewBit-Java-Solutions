/*
* Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.
* Notes: Expected solution is linear in time and constant in space.
* For example,
    List 1-->2-->1 is a palindrome.
    List 1-->2-->3 is not a palindrome.
*
* Approach: Find the middle of the linked list.
    * Reverse the second half of the linked list.
    * Check if the first half and second half are identical.
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
    public int lPalin(ListNode head) {
        // If the linkedlist is empty or contains only single element.
        if (head == null || head.next == null) {
            return 1;
        }
        ListNode slowPointer = head, fastPointer = head, midNode = null;
        ListNode prevOfSlowPointer = null, firstHalf = null, secondHalf = null;
        // To find middle element
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            prevOfSlowPointer = slowPointer;
            slowPointer = slowPointer.next;
        }

        // To handle the case of odd elements
        if (fastPointer != null) {
            midNode = slowPointer;
            slowPointer = slowPointer.next;
        }

        prevOfSlowPointer.next = null;
        firstHalf = head;
        // Reverse the second half
        secondHalf = reverse (slowPointer);

        // Now compare every element in first half and second half.
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return 0;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return 1;
    }

    public ListNode reverse (ListNode head) {
        ListNode prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
