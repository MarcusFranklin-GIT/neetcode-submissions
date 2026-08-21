class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for(int first =0; first< nums.length-1 ; first++){
            if(first>0 && nums[first]==nums[first-1])continue;

            int second = first+1;
            int third = nums.length-1;

            while(second < third){
                int sum = nums[first]+nums[second]+nums[third];
                List<Integer> curr = new ArrayList<>();

                if(sum==0){
                    curr.add(nums[first]);
                    curr.add(nums[second]);
                    curr.add(nums[third]);

                    res.add(curr);
                    
                    second++;
                    third--;

                    while(second < third && nums[second]==nums[second-1])second++;
                    while(second < third && nums[third]==nums[third+1])third--;
                }else if(sum<0)second++;
                else third--;
            }
        }
        return res;
    }
}
