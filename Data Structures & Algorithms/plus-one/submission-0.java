class Solution {
    public int[] plusOne(int[] digits) {
        int carry =1;
        for(int i = digits.length-1 ; i>=0 && carry==1 ;i--){
            int num = digits[i]+carry;
            digits[i] = num%10;
            carry = num/10;
        }
        int result[] = new int[digits.length+1];
        if(carry == 1)result[0]=1;

        return carry ==1 ? result : digits;
    }
}
