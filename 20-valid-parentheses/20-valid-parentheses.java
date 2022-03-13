class Solution {
//     public boolean isValid(String s) {
        
//     Stack<Character> stack = new Stack<Character>();
// 	for (char c : s.toCharArray()) {
// 		if (c == '(')
// 			stack.push(')');
// 		else if (c == '{')
// 			stack.push('}');
// 		else if (c == '[')
// 			stack.push(']');
// 		else if (stack.isEmpty() || stack.pop() != c)
// 			return false;
// 	}
// 	return stack.isEmpty();
//     }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                if(c == ')' && '(' != stack.pop())  return false;         
                if(c == '}' && '{' != stack.pop())  return false;
                if(c == ']' && '[' != stack.pop())  return false;
            }
        }
        return stack.isEmpty();
    }
}
