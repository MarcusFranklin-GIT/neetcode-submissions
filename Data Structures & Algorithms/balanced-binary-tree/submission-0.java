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
    boolean isvalid = true;

    public boolean isBalanced(TreeNode root) {
        check(root);
        return isvalid;
    }
    public int check(TreeNode root){
        if(root == null)return 0;

        int left = check(root.left);
        if(!isvalid)return 1;
        int right = check(root.right);

        if(Math.abs(left-right) > 1) isvalid = false;

        return 1 + Math.max(left,right);
    }
}









