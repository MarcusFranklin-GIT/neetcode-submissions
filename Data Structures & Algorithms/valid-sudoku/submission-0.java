class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int Rows[] = new int[9];
        int Cols[] = new int[9];
        int Box[] = new int[9];

        for(int row = 0 ; row<9 ; row++){
            for(int col = 0 ; col<9 ; col++){
                if(board[row][col]!='.'){
                    int val = 1<<(board[row][col]-'0');

                    if((val & Rows[row])!=0 || (val & Cols[col])!=0 || (val & Box[getInd(row,col)])!=0 ){
                        return false;
                    }

                    Rows[row]|=val;
                    Cols[col]|=val;
                    Box[getInd(row,col)]|=val;
                }
            }
        }
        return true;
    }
    public int getInd(int row,int col){
        return (3*(row/3))+(col/3);
    }
}
