class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];

        int start =1;
        int end = 1;

        int len = nums.length;

        for(int i = 0 ; i < len ; i++){
            if(start==0)start =1;
            if(end == 0)end = 1;
            
            start*= nums[i];
            end  *= nums[len -1 -i];


            max =Math.max(max,Math.max(start,end));
        }
        return max;
    }
}
