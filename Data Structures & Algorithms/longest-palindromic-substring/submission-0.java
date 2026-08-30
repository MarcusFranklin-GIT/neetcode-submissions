class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();

        int reslen = 1;
        String result = "-1";

        int dp[][] = new int[len][len];

        for(int i = 0 ; i < len ; i++){
            dp[i][i] =1;
            result = s.substring(i,i+1);
        }


        for(int col = 2 ; col<=len ; col++){
            for(int row = 0 ; row<=len-col ; row++){
                
                if(s.charAt(row) == s.charAt(row+col-1)){

                    if(col<=3){
                        dp[row][row+col-1]=1;
                        result = s.substring(row,row+col);
                    }else if(dp[row+1][row+col-2] == 1){
                        dp[row][row+col-1] = 1;
                        result = s.substring(row,row+col);
                    }
                }
            }
        }
        return result;
    }
}
