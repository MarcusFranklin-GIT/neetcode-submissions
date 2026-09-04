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
    int goodcount = 0;
    public int goodNodes(TreeNode root) {

        getnodes(root,root.val);
        return goodcount;

    }
    public void getnodes(TreeNode root,int max){

        if(root == null)return;
        if(root.val >= max) goodcount++;

        getnodes(root.left,Math.max(max,root.val));
        getnodes(root.right,Math.max(max,root.val));
    }
}
