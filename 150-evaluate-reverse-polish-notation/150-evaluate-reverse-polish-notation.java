class Solution {
    
    public int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<A.length; i++) {
            String val = A[i];
            if(val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int ans = 0;
                if(val.equals("+")) ans = num2 + num1;
                if(val.equals("-")) ans = num2 - num1;
                if(val.equals("*")) ans = num2 * num1;
                if(val.equals("/")) ans = num2 / num1;
                stack.push(ans);
            } else {
                int num = Integer.valueOf(val);
                stack.push(num);
            }
        }
        return stack.peek();
    }
}