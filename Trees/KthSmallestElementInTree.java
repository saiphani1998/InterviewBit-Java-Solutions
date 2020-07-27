/*
* Given a binary search tree, write a function to find the kth smallest element in the tree.
* Example :
    Input :
          2
         / \
        1   3
        and k = 2
    Return : 2, As 2 is the second smallest element in the tree.
* NOTE : You may assume 1 <= k <= Total number of nodes in BST
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
    public int kthsmallest(TreeNode A, int B) {
        Stack<TreeNode> stack = new Stack<>();

        while(A != null) {
            stack.push(A);
            A = A.left;
        }

        while (B != 0) {
            TreeNode node = stack.pop();
            B--;
            if (B==0) {
                return node.val;
            }
            TreeNode right = node.right;

            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }

        return -1;
    }
}
