/*
* Sort a linked list in O(n log n) time using constant space complexity.
* Example :
    Input : 1 -> 5 -> 4 -> 3
    Returned list : 1 -> 3 -> 4 -> 5
*
* Approach: Merge Sort implementation.
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
    public ListNode sortList(ListNode A) {
        return mergeSort(A);
    }

    ListNode getMiddle(ListNode h){
        if(h == null){
            return null;
        }
        ListNode slow = h;
        ListNode fast = h.next;

        while(fast!=null){
            fast = fast.next;
            if(fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    ListNode sortedMerge(ListNode left, ListNode right){
        ListNode result = new ListNode(0);
        ListNode last = result;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                last.next = left;
                left = left.next;
            }
            else{
                last.next = right;
                right = right.next;
            }
            last= last.next;
        }

        if(left == null){
            last.next = right;
        }
        if(right == null){
            last.next = left;
        }
        return result.next;
    }

    ListNode mergeSort(ListNode root){
        if(root == null || root.next == null){
            return root;
        }

        ListNode middle = getMiddle(root);
        ListNode nextToMiddle = middle.next;

        middle.next = null;
        ListNode left = mergeSort(root);
        ListNode right = mergeSort(nextToMiddle);

        ListNode result = sortedMerge(left,right);

        return result;
    }
}
