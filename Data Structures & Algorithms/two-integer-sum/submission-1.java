class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(map.get(target-num)==null){
                map.put(num,i);
            }else{
                return new int[]{map.get(target-num),i};
            }
        }
        return new int[]{0,0};
    }
}
