class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int maxarea = 0;
        int len = heights.length;

        Stack<Integer> stk= new Stack<>();

        for(int i =0 ; i<=len ;i++){

            while(!stk.isEmpty() && (i==len || heights[i] < heights[stk.peek()])){

                int height = heights[stk.pop()];
                
                int width = stk.isEmpty()? i : i - stk.peek() -1;

                int area = height * width;

                maxarea = Math.max(maxarea,area);
            }
            stk.push(i);
        } 
        return maxarea;
    }
}
