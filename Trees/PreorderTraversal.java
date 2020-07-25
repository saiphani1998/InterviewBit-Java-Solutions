/*
* Given a binary tree, return the preorder traversal of its nodes’ values.
* Example :
    Given binary tree

       1
        \
         2
        /
       3
    return [1,2,3].
* Using recursion is not allowed.
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
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (A == null) {
            return ans;
        }
        stack.push(A);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            ans.add(temp.val);

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return ans;
    }
}
