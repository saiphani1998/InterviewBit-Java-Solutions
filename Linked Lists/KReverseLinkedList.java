/*
* Given a singly linked list and an integer K, reverses the nodes of the
* list K at a time and returns modified linked list.
* NOTE : The length of the list is divisible by K
* Example :
    Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
    You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
* Try to solve the problem using constant extra space.
*
* Approach: Reverse linked list blockwise of length k and keep attaching each block
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
    public ListNode reverseList(ListNode A, int B) {
        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        while (count < B && current != null) { // reverse upto k nodes, if exists
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            A.next = reverseList(next, B); // reverse next block of k items

        return prev;
    }
}
