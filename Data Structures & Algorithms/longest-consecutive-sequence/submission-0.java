class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=0;

        for(int num : nums){
            if(map.get(num)!=null)continue;
            int len = map.getOrDefault(num-1,0)+map.getOrDefault(num+1,0)+1;
            map.put(num,len);
            map.put(num-map.getOrDefault(num-1,0),len);
            map.put(num+map.getOrDefault(num+1,0),len);
            max= Math.max(max,len);
        }
        return max;
    }
}
