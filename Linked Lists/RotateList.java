/*
*Given a list, rotate the list to the right by k places, where k is non-negative.
* For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
*
* Approach: Calculate the length
    * 2) Move to the (k-n%k)th node
    * 3) Perform the rotation manipulations
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
    public ListNode rotateRight(ListNode A, int B) {
        if (A == null || A.next == null || B == 0) {
            return A;
        }
        ListNode head = A;
        int count = 1;
        while (head.next != null) {
            head = head.next;
            count++;
        }
        if (B%count == 0) {
            return A;
        }
        ListNode last = head;
        head = A;
        int i = 1;
        while (head != null && head.next != null) {
            if (i == count - (B%count)) {
                break;
            }
            head = head.next;
            i++;
        }
        ListNode temp = head.next;
        head.next = null;
        last.next = A;
        A = temp;;
        return A;
    }
}
