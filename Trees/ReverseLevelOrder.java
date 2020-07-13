/*
* Given a binary tree, return the reverse level order traversal of its nodes values.
* (i.e, from left to right and from last level to starting level).
* Problem Constraints:
    1 <= number of nodes <= 5 * 105
    1 <= node value <= 105
* Input Format: First and only argument is a pointer to the root node of the Binary Tree, A.
* Output Format: Return an integer array denoting the reverse level order traversal from left to right.
* Example Input
    Input 1:
            3
           / \
          9  20
            /  \
           15   7
    Input 2:
           1
          / \
         6   2
            /
           3
* Example Output
    Output 1: [15, 7, 9, 20, 3]
    Output 2: [3, 6, 2, 1]
* Example Explanation
    * Explanation 1:
         Nodes as level 3 : [15, 7]
         Nodes at level 2: [9, 20]
         Nodes at level 1: [3]
         Reverse level order traversal will be: [15, 7, 9, 20, 3]
    * Explanation 2:
         Nodes as level 3 : [3]
         Nodes at level 2: [6, 2]
         Nodes at level 1: [1]
         Reverse level order traversal will be: [3, 6, 2, 1]
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
    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> resList = new ArrayList<>();
        if(root == null) {
            return resList;
        }
        ArrayList<ArrayList<Integer>> tempList = new ArrayList<>();
        dfs(root, 0, tempList);
        for (ArrayList temp : tempList) {
            resList.addAll(temp);
        }
        return resList;
    }

    public void dfs(TreeNode root, int depth, ArrayList<ArrayList<Integer>> res) {
        if(root == null) {
            return;
        }

        if(depth == res.size()) {
            res.add(0, new ArrayList<Integer>());
        }

        res.get(res.size() - depth - 1).add(root.val);
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
}
