/*
* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
* Example :
        1
       / \
      2   2
     / \ / \
    3  4 4  3
* The above binary tree is symmetric.
* But the following is not:
        1
       / \
      2   2
       \   \
       3    3
* Return 0 / 1 ( 0 for false, 1 for true ) for this problem
* */

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int isSymmetric(TreeNode A) {
        boolean b = isSymmetricUtil(A.left,A.right);
        return b ? 1 : 0;
    }

    public boolean isSymmetricUtil(TreeNode t1,TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            boolean b1 = isSymmetricUtil(t1.left,t2.right);
            boolean b2 = isSymmetricUtil(t1.right,t2.left);

            if(b1 && b2) {
                return true;
            }
        }
        return false;
    }
}
