/*
* A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
* Return a deep copy of the list.
Example:
    Given list
       1 -> 2 -> 3
    with random pointers going from

      1 -> 3
      2 -> 1
      3 -> 1
* You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them.
* The pointers in the returned list should not link to any node in the original input list.
* 
* */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode node1 = head;
        RandomListNode node2 = newHead;

        map.put(node1, node2);
        node1 = node1.next;

        while(node1 != null) {
            RandomListNode temp = new RandomListNode(node1.label);
            map.put(node1, temp);
            node2.next = temp;
            node2 = node2.next;
            node1 = node1.next;
        }

        node1 = head;
        node2 = newHead;

        while(node1 != null) {
            if(node1.random != null) {
                node2.random = map.get(node1.random);
            }
            else {
                node2.random = null;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        return newHead;
    }
}
