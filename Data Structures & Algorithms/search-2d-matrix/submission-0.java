class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length;
        int C = matrix[0].length;

        int start =0;
        int end = R*C-1;

        while(start <= end){
            int mid = start+(end-start)/2;

            int row = mid/C;
            int col = mid%C;

            if(matrix[row][col] == target)return true;
            else if(matrix[row][col] < target)start = mid+1;
            else end = mid-1;

        }
        return false;
    }
}
