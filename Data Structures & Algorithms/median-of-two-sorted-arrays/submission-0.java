class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] A = nums1;
        int[] B = nums2;

        if(A.length > B.length){
            int temp[]= A;
            A = B;
            B = temp;
        }

        int len1 = A.length;
        int len2 = B.length;
        int total = len1 + len2;

        int half = (total+1)/2;

        int l =  0;
        int r = len1;

        while(l <= r){
            int halfA = (l+r)/2;
            int halfB = half - halfA;

            int leftA = halfA > 0 ? A[halfA-1] : Integer.MIN_VALUE;
            int rightA = halfA <len1 ? A[halfA] : Integer.MAX_VALUE;

            int leftB = halfB > 0 ? B[halfB-1] : Integer.MIN_VALUE;
            int rightB = halfB < len2 ? B[halfB] : Integer.MAX_VALUE;

            if(leftA <= rightB && leftB <= rightA){
                if(total %2  != 0) return Math.max(leftA,leftB);
                else{
                    return (Math.max(leftA,leftB) + Math.min(rightA,rightB)) / 2.0;
                }
            }else if(leftA > rightB){
                r = halfA - 1;
            }else{
                l = halfA + 1;
            }
        }
        return -1;
    }
}
