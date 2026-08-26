class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int len = temperatures.length;
        Stack<Integer> stk = new Stack<>();

        int res[] = new int[len];

        for(int i=0 ; i<len ; i++){
            
            while(!stk.isEmpty() && temperatures[stk.peek()] < temperatures[i]){
                res[stk.peek()] = i-stk.peek();
                stk.pop();
            }
            stk.push(i);
        }

        while(!stk.isEmpty())res[stk.pop()]= 0;

        return res;
    }
}
