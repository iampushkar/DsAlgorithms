class Solution {
    public String removeDuplicates(String s, int k) {
        int N = s.length();
        Stack<Node> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().c == ch) {
                stack.peek().count++;
            } else {
                stack.push(new Node(ch, 1));
            }
            
            if(stack.peek().count == k) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Node n : stack) {
            int count = n.count;
            while(count > 0) {
                sb.append(n.c);
                count--;
            }
        }
        return sb.toString();
    }
    
    class Node {
        char c;
        int count;
        Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}