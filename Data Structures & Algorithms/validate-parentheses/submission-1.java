class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i=0 ; i < s.length() ; i++){
            char symbol = s.charAt(i);
            if(symbol == '(' || symbol == '[' || symbol == '{'){
                stk.push(symbol);
            }else{
                if(!stk.isEmpty()){
                    if(symbol == ')' && stk.peek() == '(')stk.pop();
                    else if(symbol == ']' && stk.peek() == '[')stk.pop();
                    else if(symbol == '}' && stk.peek() == '{')stk.pop();
                    else return false;
                }else {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
