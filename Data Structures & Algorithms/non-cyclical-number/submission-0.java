class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> set = new HashSet<>();
        int num = n;
        while(!set.contains(num)){
            set.add(num);
            num = square_sum(num);
            if(num == 1)return true;
        }
        return false;
    }
    public int square_sum(int num){
        int sum =0;
        while(num > 0){
            sum += (num%10) * (num%10);
            num/=10;
        }
        return sum;
    }

}
