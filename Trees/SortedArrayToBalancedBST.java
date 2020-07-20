/*
* Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
* Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
* Example :
    Given A : [1, 2, 3]
    A height balanced BST:
          2
        /   \
       1     3
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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    // public TreeNode sortedArrayToBST(final int[] A) {
    // }
    public TreeNode helper(List<Integer> a , int start, int end){

        if(start>end){
            return null;
        }

        int mid = start + (end-start)/2;

        TreeNode root = new TreeNode(a.get(mid));

        root.left = helper(a,start,mid-1);
        root.right = helper(a,mid+1,end);

        return root;
    }

    public TreeNode sortedArrayToBST(final List<Integer> a) {

        return helper(a,0,a.size()-1);
    }
}
