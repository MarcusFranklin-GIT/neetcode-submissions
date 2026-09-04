class Solution {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        int left = kthSmallest(root.left,k);
        if(left != -1)return left;

        if(count+1 == k)return root.val;
        count++;

        int right = kthSmallest(root.right,k);
        if(right != -1)return right;

        if(count == k)return root.val;
        return -1;
    }
}