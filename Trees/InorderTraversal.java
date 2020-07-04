/*
* Given a binary tree, return the inorder traversal of its nodes’ values.
* Example :
    Given binary tree

       1
        \
         2
        /
       3
    return [1,3,2].
* Note: Using recursion is not allowed.
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || s.size() > 0) {
            while (curr !=  null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            resultList.add(curr.val);
            curr = curr.right;
        }
        return resultList;
    }
}
