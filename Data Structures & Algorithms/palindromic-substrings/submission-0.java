class Solution {
    public int countSubstrings(String s) {
        
        int len = s.length();


        int dp[][] = new int[len][len];

        for(int i = 0 ; i < len ; i++){
            dp[i][i] =1;
        }

        int count = s.length();
        for(int col = 2 ; col<=len ; col++){
            for(int row = 0 ; row<=len-col ; row++){
                
                if(s.charAt(row) == s.charAt(row+col-1)){

                    if(col<=3){
                        dp[row][row+col-1]=1;
                        count++;
                    }else if(dp[row+1][row+col-2] == 1){
                        dp[row][row+col-1] = 1;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
