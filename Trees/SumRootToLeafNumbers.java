/*
* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number
* An example is the root-to-leaf path 1->2->3 which represents the number 123.
* Find the total sum of all root-to-leaf numbers % 1003.
* Example :
        1
       / \
      2   3
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
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
    public int sumNumbers(TreeNode A) {
        return sum(A, 0)%1003;
    }

    public int sum(TreeNode root, int mul) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return (mul*10 + root.val)%1003;
        }

        int num = mul*10 + root.val;
        num %= 1003;
        int ans = (sum(root.left, num) + sum(root.right, num));

        return ans%1003;
    }
}
