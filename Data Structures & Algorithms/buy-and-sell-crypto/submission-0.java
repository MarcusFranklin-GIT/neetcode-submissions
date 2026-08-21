class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int min = prices[0];

        for(int num : prices){
            min = Math.min(min,num);
            profit = Math.max(profit,num-min);
        }

        return profit;
    }
}
