class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int len = position.length;

        int pair[][] = new int[len][2];

        //convert to 2D pair of starting position and the speed they can move
        for(int i =0 ; i<len ; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        //sor the pairs based on the staring position (last first) 
        Arrays.sort(pair , (a,b)-> Integer.compare(b[0],a[0]));

        Stack<Double> stk = new Stack<>();

        for(int p[] : pair){
            double currtime  = (double)(target - p[0])/p[1];
            
            if(stk.isEmpty() || stk.peek() < currtime){
                stk.push(currtime);
            }
        }

        return stk.size();
    }
}