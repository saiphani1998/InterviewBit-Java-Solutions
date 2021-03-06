/*
* Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
* For example:
    Given the below binary tree and sum = 22,

                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \    / \
            7    2  5   1
    return,
        [
           [5,4,11,2],
           [5,8,4,5]
        ]
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
    private ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    public void pathSumInner(TreeNode root, int sum, Stack<Integer>path) {
        path.push(root.val);

        if(root.left == null && root.right == null) {
            if(sum == root.val) resultList.add(new ArrayList<Integer>(path));
        }

        if(root.left!=null) pathSumInner(root.left, sum-root.val, path);
        if(root.right!=null)pathSumInner(root.right, sum-root.val, path);

        path.pop();
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return resultList;
        Stack<Integer> path = new Stack<Integer>();
        pathSumInner(root, sum, path);
        return resultList;
    }
}
