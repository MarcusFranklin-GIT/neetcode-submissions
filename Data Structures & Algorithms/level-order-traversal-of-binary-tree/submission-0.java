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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> Q = new LinkedList<>();

        if(root == null)return result;

        Q.add(root);

        while(!Q.isEmpty()){

            int size = Q.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                
                TreeNode curr = Q.poll();
                list.add(curr.val);

                if(curr.left != null)Q.add(curr.left);
                
                if(curr.right != null)Q.add(curr.right);
            }            
            result.add(list);
        }
        return result;
    }
}







