class Solution {
    int diff[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        
        int R = grid.length;
        int C = grid[0].length;

        int count=0;
        for(int row = 0 ; row < R ;row++){
            for(int col = 0 ; col < C ; col++){
                if(grid[row][col] == '1'){
                    count++;
                    DFS(row,col,R,C,grid);
                }
            }
        }
        return count;
    }
    public void DFS(int row,int col,int R , int C,char[][] grid){
        grid[row][col] = '0';
        for(int dir[] : diff){
            int currR = row+dir[0];
            int currC = col+dir[1];

            if(currR < R && currC <C && currR>=0 && currC>= 0 && grid[currR][currC] == '1'){
                DFS(currR,currC,R,C,grid);
            }
        }
    }
}
