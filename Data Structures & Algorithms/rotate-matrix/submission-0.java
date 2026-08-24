class Solution {
    public void rotate(int[][] matrix) {
        
        int R = matrix.length;
        int C = matrix[0].length;
        //transpose
        for(int i = 0 ; i < R ;i++){
            for(int j = i+1 ; j < C ;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse

        for(int i=0;i < R ;i++){
            int start =0 ;
            int end = C-1;
            while(start < end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}
