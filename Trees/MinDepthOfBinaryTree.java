/*
* Given a binary tree, find its minimum depth.
* The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
* NOTE : The path has to end on a leaf node.
* Example :
         1
        /
       2
    min depth = 2.
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
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode A) {
        if (A == null) {
            return 0;
        }
        minDepthUtil(A,1);
        return min;
    }
    private void minDepthUtil(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > min) {
            return;
        }

        if (node.right == null && node.left == null) {
            if (min > depth) {
                min = depth;
            }
        }
        minDepthUtil(node.left, depth+1);
        minDepthUtil(node.right, depth+1);
    }
}
