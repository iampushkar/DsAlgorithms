class MinStack {
    
    Stack<Long> stack;
    long minElement;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(1L*x);
            minElement = x;
        } else {
            if(x >= minElement) {
                stack.push(1L*x);
            } else if(x < minElement) { // flag
                long val = 1L * 2 * x - minElement;  // top = 2 * currMin - prevMin
                stack.push(val);
                minElement = x;
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        } else {
            long top = stack.peek();
            if(top >= minElement) {
                stack.pop();
            } else if(top < minElement) { // flag
                long val = 1L * 2 * minElement - top; // prevMin = 2 * currMin - top
                stack.pop();
                minElement = val;
            }
        }
    }

    public int top() {
        long ans = -1;
        if(stack.isEmpty()) {
            return (int)ans;
        } else {
            long top = stack.peek();
            if(top >= minElement) {
                ans = top;
            } else if(top < minElement) { // flag
                ans = minElement;
            }
        }
        return (int)ans;
    }

    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }
        return (int)minElement;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */