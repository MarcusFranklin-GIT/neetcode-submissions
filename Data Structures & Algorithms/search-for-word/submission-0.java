class Solution {
    int visited[][];
    int diff[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        
        int R = board.length;
        int C = board[0].length;

        visited = new int[R][C];

        for(int row = 0 ; row < R ; row++){
            for(int col = 0 ; col < C ;col++){
                if(board[row][col] == word.charAt(0)){
                    visited[row][col] = 1;
                    if(DFS(row,col,R,C,0,word,board))return true;
                    visited[row][col] = 0;
                }
            }
        }
        return false;
    }
    public boolean DFS(int r,int c, int R,int C,int ind,String word,char [][] board){

        if(ind == word.length()-1)return true;

        for(int dir[] : diff){
            int currR = r + dir[0];
            int currC = c + dir[1];

            if(currR >= R || currR < 0 || currC >= C || currC < 0 || visited[currR][currC] == 1) continue;

            if(board[currR][currC] == word.charAt(ind+1)){
                visited[currR][currC] = 1;
                if(DFS(currR,currC,R,C,ind+1,word,board))return true;
                visited[currR][currC] = 0;
            }
        }
        return false;
    }
}







