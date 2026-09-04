class Solution {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return find(root,k);
    }
    public int find(TreeNode root,int k){
        if(root == null){
            return -1;
        }
        int left = find(root.left,k);
        if(left != -1)return left;

        if(count+1 == k)return root.val;
        count++;

        int right = find(root.right,k);
        if(right != -1)return right;

        if(count == k)return root.val;
        return -1;
    }
}