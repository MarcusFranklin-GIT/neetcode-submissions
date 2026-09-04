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
    public boolean isSame(TreeNode main,TreeNode sub){
        if(main == null && sub == null)return true;

        if(main == null || sub == null)return false;

        if(main.val != sub.val) return false;

        return isSame(main.left,sub.left) && isSame(main.right,sub.right);

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null || subRoot == null)return false;

        if(isSame(root,subRoot))return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot); 
    }
}
