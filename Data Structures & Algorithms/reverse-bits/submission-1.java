class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int count = 0;

        while (count < 32) {
            int val = n & 1;
            n = (n >>> 1);
            ans = (ans << 1) | val;
            count++;
        }
        return ans;
    }
}
