class Solution {
    public int trap(int[] height) {
        int len=height.length;
        int maxpoint = 0;

        int totalwater=0;
        int water=0;

        for(int right=0 ; right<len ; right++){
            
            if(height[maxpoint]<=height[right]){
                totalwater+=water;
                water=0;
                maxpoint=right;
            }else{
                water+=height[maxpoint]-height[right];
            }
        }
        int second_maxpoint=len-1;
        water=0;
        for(int left = len-1 ; left>=maxpoint ; left--){
            if(height[second_maxpoint] <= height[left]){
                totalwater+=water;
                water=0;
                second_maxpoint=left;
            }else{
                water+=height[second_maxpoint]-height[left];
            }
        }

        return totalwater;
    }
}
