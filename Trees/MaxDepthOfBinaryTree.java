/*
* Given a binary tree, find its maximum depth.
* The maximum depth of a binary tree is the number of nodes along the longest path
    from the root node down to the farthest leaf node.

* NOTE : The path has to end on a leaf node.
* Example :
             1
            /
           2
    max depth = 2.
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
    int max = 0;
    public int maxDepth(TreeNode A) {
        max = 0;
        maxDepthHelper(A,1);
        return max;
    }

    private void maxDepthHelper(TreeNode node, int height) {
        if (node == null) {
            return;
        }

        if (node.right == null && node.left == null) {
            if (height > max) {
                max = height;
            }
        }

        maxDepthHelper(node.left, height+1);
        maxDepthHelper(node.right, height+1);
    }
}
