class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int possible[] = new int[amount+1];
        Arrays.fill(possible,amount+1);
        possible[0] = 0;

        for(int i=1; i<=amount ; i++ ){
            for(int coin : coins){
                if(i>=coin) possible[i] = Math.min(possible[i],possible[i-coin]+1); 
            }
        }

        return possible[amount]>amount ? -1 : possible[amount];
    }
}
