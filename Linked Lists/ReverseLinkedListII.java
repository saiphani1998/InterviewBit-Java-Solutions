/*
* Reverse a linked list from position m to n. Do it in-place and in one-pass.
* For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,
    return 1->4->3->2->5->NULL.
*
* Approach: traverse till mth node and keep track of mthprevnode and reverse the list from there till nth node
    * and attach the both the ends of reversed list to mthprev and nth next;
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
    public ListNode reverseBetween(ListNode A, int m, int n) {
        // if given list is empty or single
        if (A == null || A.next == null) {
            return A;
        }

        // if m==n then no reversal will happen
        if (m == n) {
            return A;
        }

        // if the reversal to be done is from the 1st node.
        if (m == 1) {
            return reverse (A, n-m+1);
        }

        ListNode head = A, prevNode = null;
        int count = 0;

        while (head != null) {
            count++;
            if (count == m-1) {
                prevNode = head;
            }
            if (count == m) {
                prevNode.next = reverse(head,n-m+1);
                break;
            }
            head = head.next;
        }
        return A;
    }

    public ListNode reverse(ListNode head, int n) {
        int count = 0;
        ListNode current = head, prev = null, next = null;
        while (count<n && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        head.next = next;
        return prev;
    }
}
