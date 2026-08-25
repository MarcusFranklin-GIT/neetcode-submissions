class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stk = new Stack<>();

        for(String str: tokens){
            if(str.equals("+")){
                int ele1 = stk.pop();
                int ele2 = stk.pop();
                stk.push(ele2 + ele1);
            }else if(str.equals("-")){
                int ele1 = stk.pop();
                int ele2 = stk.pop();
                stk.push(ele2 - ele1);
            }else if(str.equals("*")){
                int ele1 = stk.pop();
                int ele2 = stk.pop();
                stk.push(ele2 * ele1);
            }else if(str.equals("/")){
                int ele1 = stk.pop();
                int ele2 = stk.pop();
                stk.push(ele2 / ele1);
            }else{
                stk.push(Integer.parseInt(str));
            }
        }
        return stk.peek();
    }
}
