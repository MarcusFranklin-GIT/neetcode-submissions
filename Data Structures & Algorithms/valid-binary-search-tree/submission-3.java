/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean checkTree(TreeNode root,int minimum,int maximum){
        
        if(root == null)return true;

        if(root.val >= maximum || root.val <= minimum)return false;

        return checkTree(root.left,minimum,root.val) && checkTree(root.right,root.val,maximum);
    }
}
