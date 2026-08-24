class MinStack {
    private Deque<int[]> stack;
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int cur[] = new int[2];
        cur[0] = val;
        if(!stack.isEmpty()){
            cur[1] = Math.min(val,stack.peek()[1]);
        }else{
            cur[1] = val;
        }
        stack.push(cur);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
