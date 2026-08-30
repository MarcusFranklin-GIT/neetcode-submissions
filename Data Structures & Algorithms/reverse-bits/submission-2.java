class Solution {
    public int reverseBits(int n) {

        if(n==0)return 0;
        int ans =0;
        int count =0;

        while(n!=0){
            int val = n & 1;
            n = (n>>>1);
            ans = (ans<<1)|val;
            count++;
        }
        return ans<<(32-count);
    }
}
