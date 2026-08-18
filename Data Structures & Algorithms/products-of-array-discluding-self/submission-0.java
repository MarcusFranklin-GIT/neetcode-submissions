class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int prefix[] = new int[len];
        int suffix[] = new int[len];

        prefix[0] = nums[0];
        suffix[len-1] = nums[len-1];

        for(int i=1; i<len ; i++){
            prefix[i] = prefix[i-1]*nums[i];
            suffix[len-1-i] = suffix[len-i]*nums[len-i-1];
        }

        int res[] = new int[len];
        res[0] = suffix[1];
        res[len-1] = prefix[len-2];

        for(int i=1 ; i<len-1 ; i++){
            res[i] = prefix[i-1]*suffix[i+1];
        }
        return res;
    }
}  
