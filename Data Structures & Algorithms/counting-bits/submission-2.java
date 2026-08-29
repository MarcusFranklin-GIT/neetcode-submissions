class Solution {
    public int[] countBits(int n) {

        if(n<=1){
            return n==0 ? new int[]{0} : new int[]{0,1};
        }

        int result[] = new int[n+1];

        result[0] = 0;
        result[1] = 1;
        


        for(int i = 2; i <= n ;i++){
            result[i] = (i%2)+ result[i/2];
        }
        return result;
    }
}
