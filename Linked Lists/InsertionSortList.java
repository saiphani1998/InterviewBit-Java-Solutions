/*
* Sort a linked list using insertion sort.
* Example :
    Input : 1 -> 3 -> 2
    Return 1 -> 2 -> 3
*
* Approach: Create an empty sorted (or result) list.
    * Traverse the given list, do following for every node.
        * Insert current node in sorted way in sorted or result list.
    * Change head of given linked list to head of sorted (or result) list.
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
    ListNode sorted;
    public ListNode insertionSortList(ListNode A) {
        sorted = null;
        ListNode current = A;
        while (current != null) {
            ListNode next = current.next;
            sortedInsert(current);
            current = next;
        }
        A = sorted;
        return A;
    }
    public void sortedInsert(ListNode newnode) {
        if (sorted == null || sorted.val >= newnode.val) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            ListNode current = sorted;
            while (current.next != null && current.next.val < newnode.val) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }
}
