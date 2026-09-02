class Solution {
    public int maxCoins(int[] nums) {

        int len = nums.length;

        int newnums[] = new int[len+2];

        for(int i = 0 ; i < len ; i++){
            newnums[i+1] = nums[i];
        }

        newnums[0] = 1;
        newnums[len+1] = 1;

        int dp[][] = new int[len+1][len+1];
        for(int row[] : dp)Arrays.fill(row,-1);

        return burst(1,len,newnums,dp);
        
    }

    private int burst(int left , int right , int[] nums,int dp[][]){
        
        if(left > right)return 0;

        if(dp[left][right] != -1) return dp[left][right];

        int maxi = Integer.MIN_VALUE;

        for(int ind = left ; ind <= right ; ind++){
            
            int call1 = burst(left,ind-1,nums,dp);
            int call2 = burst(ind+1,right,nums,dp);
            
            int cost = (nums[left-1] * nums[ind] * nums[right+1])+ call1 + call2;

            maxi = Math.max(maxi,cost);
        }

        return dp[left][right] = maxi;
    }
}






