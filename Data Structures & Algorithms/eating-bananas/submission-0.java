class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        long min = 1;
        long max = piles[0];

        for(int num : piles){
            // min = Math.min(min,num);
            max = Math.max(max,num);
        }

        while(min <= max){
            long mid = min + (max-min)/2;

            long hours =0;
            for(int pile : piles){
                hours += (pile + (mid-1))/mid;
            }

            if(hours <= h){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return (int)min;
    }
}