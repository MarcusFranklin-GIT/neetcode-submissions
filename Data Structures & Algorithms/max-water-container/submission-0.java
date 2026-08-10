class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;

        int ans=0;

        while(left<right){
            int height = Math.min(heights[left],heights[right]);
            int breth = right-left;

            ans = Math.max(ans,height*breth);

            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return ans;
    }
}
