/*
* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
* Try solving it using constant additional space.
* Example :
    Input :
                      ______
                     |     |
                     \/    |
            1 -> 2 -> 3 -> 4

    Return the node corresponding to node 3.
*
* Approach: Use slow pointer and fast pointer technique.
    * If the loop does not exists, both the pointers do not meet. (basically fastpointer becomes null)
    * If at all loop exists, then both the pointers meet (But not always start point) anywhere in between the cycle.
    * Now, assign the slow pointer to head again and now traverse both the pointers one step ahead until both of the pointers meet.
    * Now this meeting point is going to be the start of the cycle.
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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slowPointer = head, fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (fastPointer == slowPointer) {
                break;
            }
        }

        if (fastPointer != slowPointer) {
            return null;
        }

        slowPointer = head;
        while (fastPointer != slowPointer) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }
}
