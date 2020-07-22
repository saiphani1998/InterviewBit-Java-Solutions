/*
* Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
* The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.
* Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
* Try to optimize the additional space complexity apart from the amortized time complexity.
* */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public Stack<TreeNode> stack;

    public Solution(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        node = node.right;

        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        return val;
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
