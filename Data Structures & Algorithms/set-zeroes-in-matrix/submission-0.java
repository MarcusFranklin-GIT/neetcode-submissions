class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean toprow = false;
        for(int i=0 ; i<matrix[0].length ; i++){
            if(matrix[0][i] == 0){
                toprow = true;
                break;
            }
        }

        boolean leftcol = false;
        for(int i =0 ; i < matrix.length ; i++){
            if(matrix[i][0] == 0){
                leftcol = true;
                break;
            }
        }

        for(int row = 1; row< matrix.length ; row++){
            for(int col = 1 ; col < matrix[0].length ; col++){
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for(int row = 1 ; row < matrix.length ; row++){
            if(matrix[row][0] == 0){
                for(int col = 1 ; col < matrix[0].length ; col++){
                    matrix[row][col] = 0;
                }
            }
        }

        for(int col = 1 ; col < matrix[0].length ; col++){
            if(matrix[0][col] == 0){
                for(int row = 1 ; row < matrix.length ; row++){
                    matrix[row][col] = 0;
                }
            }
        }

        if(toprow){
            for(int i =0 ; i < matrix[0].length ; i++){
                matrix[0][i]=0;
            }
        }

        
        if(leftcol){
            for(int i =0 ; i < matrix.length ; i++){
                matrix[i][0]=0;
            }
        }
    }
}
