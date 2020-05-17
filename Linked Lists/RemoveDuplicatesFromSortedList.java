/*
*Given a sorted linked list, delete all duplicates such that each element appear only once.
* For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
*
* Approach: loop throgh the list and unlink the duplicate nodes.
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
    public ListNode deleteDuplicates(ListNode A) {
        ListNode prevNode = null, head = A;
        // If the given list is empty or contains single element
        if (A == null || A.next == null) {
            return A;
        }

        // Loop through the list
        while (head != null && head.next != null) {
            prevNode = head;
            head = head.next;
            // Unlink duplicates from list
            while (head != null && head.val == prevNode.val) {
                head = head.next;
            }
            prevNode.next = head;
        }
        return A;
    }
}
