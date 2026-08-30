class Solution {

    int diff[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        
        int R = grid.length;
        int C = grid[0].length;

        int oranges = 0;

        Queue<int[]> Q = new LinkedList<>();

        for(int i =0 ; i < R;i++){
            for(int j = 0; j < C ; j++){
                if(grid[i][j] == 1)oranges++;
                else if(grid[i][j] == 2){
                    Q.add(new int[]{i,j});
                }
            }
        }

        if(Q.isEmpty() && oranges == 0)return 0 ;

        int time = 0;

        while(!Q.isEmpty()){
            int size = Q.size();

            while(size-->0){
                int[]curr = Q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int dir[] : diff){
                    int adjR = r + dir[0];
                    int adjC = c + dir[1];

                    if(adjR<R && adjR>=0 && adjC<C && adjC>=0 && grid[adjR][adjC]==1){
                        Q.add(new int[]{adjR,adjC});
                        grid[adjR][adjC]=2;
                        oranges--;
                    }
                }
            } 
            time++;
        }
        return (oranges==0) ? time-1 : -1 ;
    }
}
