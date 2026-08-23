class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int reslen = len - k +1;

        int result[] = new int[reslen];
        int ptr = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0 ; i < len ; i++){

            while(!dq.isEmpty() && dq.peekFirst() < i - k + 1)dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])dq.pollLast();

            dq.addLast(i);

            if(i>= k-1){
                result[ptr++] = nums[dq.peekFirst()];
            } 
        }
        return result;
    }
}
