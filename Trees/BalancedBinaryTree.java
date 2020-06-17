/*
* Given a binary tree, determine if it is height-balanced.
* Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
* Return 0 / 1 ( 0 for false, 1 for true ) for this problem
* Example :
    Input : 
              1
             / \
            2   3
    
    Return : True or 1 
    
    Input 2 : 
             3
            /
           2
          /
         1
    
    Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1.
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
    public int isBalanced(TreeNode A) {
        if (A == null) return 1;
        if (Math.abs(height(A.left) - height(A.right)) > 1) {
            return 0;
        }

        return Math.min(isBalanced(A.left), isBalanced(A.right));
    }

    public int height(TreeNode A) {
        if (A == null) return 0;
        return 1 + Math.max(height(A.left), height(A.right));
    }
}
