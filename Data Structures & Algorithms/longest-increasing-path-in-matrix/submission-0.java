class Solution {

    int diff[][] = {{0,1},{1,0},{0,-1},{-1,0}};

    public int longestIncreasingPath(int[][] matrix) {
        
        int R = matrix.length;
        int C = matrix[0].length;

        int dp[][] = new int[R][C];

        int max = 1;

        for(int row =  0 ; row < R ; row++){
            for(int col = 0 ; col < C ; col++){
                max = Math.max(max,check(row,col,R,C,matrix,dp));
            }
        }

        return max;
    }
    public int check(int row,int col,int R,int C,int[][] matrix,int[][] dp){

        if(dp[row][col] != 0) return dp[row][col];
        
        int currmax =0;
        
        for(int dir[] : diff){
            int currR = row + dir[0];
            int currC = col + dir[1];

            if(currR >= R || currR < 0 || currC >= C || currC < 0)continue;


            if(matrix[currR][currC] < matrix[row][col]){
                currmax = Math.max(check(currR,currC,R,C,matrix,dp),currmax);
            }
        }
        return dp[row][col] = currmax + 1;
    }
}












