class MyStack {
    Queue<Integer> queue;
    
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        if(queue.isEmpty()) {
            queue.add(x);
        } else {
            Queue<Integer> temp = new LinkedList<>();
            while(!queue.isEmpty()) {
                temp.add(queue.poll());
            }
            queue.add(x);
            while(!temp.isEmpty()) {
                queue.add(temp.poll());
            }
        }
    }
    
    public int pop() {
        if(queue.isEmpty()) {
            return -1;
        } else {
            return queue.poll();
        }
    }
    
    public int top() {
        if(queue.isEmpty()) {
            return -1;
        } else {
            return queue.peek();
        }
    }
    
    public boolean empty() {
        if(queue.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */