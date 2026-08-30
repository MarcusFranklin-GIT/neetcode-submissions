class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        
        if(len == 1)return nums[0];

        int temp1[] = new int[len];
        int temp2[] = new int[len];

        for(int i=0 ; i<len ; i++){
            if(i != 0)temp1[i] = nums[i];
            if(i != len-1)temp2[i] = nums[i];
        }
        return Math.max(get_max(temp1),get_max(temp2));

    }
    public int get_max(int[] nums){
        
        int prev1 = 0;
        int prev2 = 0;

        for(int num : nums){
            int temp = prev1;
            prev1 = Math.max(prev1,prev2 + num);
            prev2 = temp;
        }
        return prev1;
    }
}