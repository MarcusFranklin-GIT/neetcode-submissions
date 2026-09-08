class Solution {
    public int missingNumber(int[] nums) {
        
        int ans = 0 ;
        int target = 0;
        for(int i = 0; i < nums.length ; i++){
            ans^=nums[i];
            target^=i+1;
        }

        return target^ans;
    }
}
