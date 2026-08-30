class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        
        int col[] = new int[n];

        int BLTR[] = new int[(2*n)-1];
        int TLBR[] = new int[(2*n)-1];

        List<List<String>> result = new ArrayList<>();

        char[][] queen = new char[n][n];

        for(char rows[] : queen)Arrays.fill(rows,'.');

        helper(0,n,col,BLTR,TLBR,queen,result);

        return result;
    }

    public void helper(int row,int n,int[] Col,int[] BLTR,int[] TLBR,char[][] queen,List<List<String>> result){

        if(row == n){
            List<String> solution = new ArrayList<>();

            for(char rows[] : queen){
                solution.add(new String(rows));
            }

            result.add(solution);
        }

        for(int col = 0 ; col < n ; col++){

            if(Col[col] == 0 && BLTR[row+col] == 0 && TLBR[n-1-row+col] == 0){
                
                //try one possible
                queen[row][col] = 'Q';
                Col[col] =1;
                BLTR[row+col] = 1;
                TLBR[n-1-row+col] =1;

                helper(row+1 , n , Col,BLTR,TLBR,queen,result);

                //backtrack
                queen[row][col] = '.';
                Col[col] = 0;
                BLTR[row+col] = 0;
                TLBR[n-1-row+col] = 0;
            }
        }
    }
}









