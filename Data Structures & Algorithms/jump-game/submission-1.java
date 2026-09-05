class Solution {
    public boolean canJump(int[] nums) {
        
        int max = 0;
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
            if(max < i)return false;
            max = Math.max(max,nums[i]+i);
            if(max >= len-1)return true;
        }
        return true;       
    }
}
