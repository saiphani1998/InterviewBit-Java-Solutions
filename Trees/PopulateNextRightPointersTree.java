/*
* Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
* Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
* Initially, all next pointers are set to NULL.
* Note: You may only use constant extra space.
* Example :
    Given the following binary tree,
             1
           /  \
          2    3
         / \  / \
        4  5  6  7
    After calling your function, the tree should look like:

             1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \  / \
        4->5->6->7 -> NULL
* Note 1: that using recursion has memory overhead and does not qualify for constant space.
* Note 2: The tree need not be a perfect binary tree.
* */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeLinkNode getNext(TreeLinkNode p){
        TreeLinkNode temp = p.next;

        while (temp!=null) {
            if (temp.left!=null) {
                return temp.left;
            } else if (temp.right!=null) {
                return temp.right;
            }
            temp = temp.next;
        }
        return null;
    }

    public void connect(TreeLinkNode A) {
        TreeLinkNode p = A;
        if (p == null) {
            return;
        }
        p.next = null;

        while(p!=null) {
            TreeLinkNode q = p;
            while (q!=null) {
                if (q.left!=null) {
                    if (q.right!=null) {
                        q.left.next = q.right;
                    } else {
                        q.left.next = getNext(q);
                    }
                }

                if (q.right!=null) {
                    q.right.next = getNext(q);
                }

                q = q.next;
            }

            if (p.left!=null) {
                p = p.left;
            } else if (p.right!=null) {
                p = p.right;
            } else {
                p = getNext(p);
            }
        }
    }
}
