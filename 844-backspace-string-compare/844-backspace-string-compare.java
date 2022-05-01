class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = delete(s);
        String t1 = delete(t);
        
        return s1.equals(t1);
    }
    
    private String delete(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && c == '#') {
                st.pop();
            } else {
                if(c != '#') {
                    st.push(c);
                }    
            }
        }
        
//         StringBuilder sb = new StringBuilder();
//         while(!st.isEmpty()) {
//             sb.append(st.pop());
//         }
        
//         return sb.reverse().toString();
        
        return String.valueOf(st);
    }
}