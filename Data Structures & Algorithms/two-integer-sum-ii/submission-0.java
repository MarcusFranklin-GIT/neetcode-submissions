class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;

        for(int ind=0 ; ind < len ; ind++){

            int rem = target-numbers[ind];
            int left = ind+1;
            int right = len-1;

            while(left<=right){
                
                int mid = left+(right-left)/2;

                if(numbers[mid] == rem){
                    return new int[]{ind+1,mid+1};
                }else if(numbers[mid] < rem){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return new int[]{};
    }
}
