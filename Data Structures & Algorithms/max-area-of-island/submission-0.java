class Solution {
    int[][] diff = {{1,0},{0,1},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int R=grid.length, C = grid[0].length;
        for(int i = 0; i < R ; i++){
            for(int j = 0; j < C ; j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(dfs(i,j,R,C,grid,0),maxArea); 
                }
            }
        }
        return maxArea;
    }
    public int dfs(int i, int j, int R, int C, int[][] grid, int area){
        area++;
        grid[i][j] = 0;
        for(int ptr = 0; ptr<4 ; ptr++){
            int adjR = diff[ptr][0]+i, adjC=diff[ptr][1]+j;
            if(adjR >= 0 && adjC >= 0 && adjR < R && adjC < C && grid[adjR][adjC] == 1)
                area= dfs(adjR,adjC,R,C,grid,area);
        }
        return area;
    }
}