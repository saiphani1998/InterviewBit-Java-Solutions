/*
* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
* For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
*
* Approach: Store the frequencies of the nodes and then re iterate through the list
    * Create a dummy head and append the nodes whose frequency is 1
    * finally return the list appended to the dummy node.
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
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        Map<Integer, Integer> map = new HashMap<>();
        ListNode curr = A;

        while(curr != null) {
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        curr = A;
        while(curr != null) {
            if (map.get(curr.val) == 1) {
                temp.next = curr;
                temp = temp.next;
            }
            curr = curr.next;
        }
        temp.next = null;
        return dummyHead.next; // Escape dummyHead;
    }
}
