/*
* Given a binary tree, flatten it to a linked list in-place.
* Example :
    Given,
             1
            / \
           2   5
          / \   \
         3   4   6
    The flattened tree should look like:

       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6
* Note that the left child of all nodes should be NULL.
* */

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode flatten(TreeNode a) {
        if (a == null) {
            return a;
        }

        TreeNode cur = a;

        while (cur!=null) {

            if (cur.left!=null) {
                TreeNode rightMost = cur.left;
                while (rightMost.right!=null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
        return a;
    }
}
