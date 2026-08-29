class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        int len = nums.length;
        List<Integer> curr= new ArrayList<>();

        add_new(curr,0,len,nums);
        return result;
    }   
    public void add_new(List<Integer> curr,int i,int len,int[] nums){
        if(i==len){
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        add_new(curr,i+1,len,nums);

        curr.remove(curr.size()-1);
        add_new(curr,i+1,len,nums);
    }
}
