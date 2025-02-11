class Solution {
    public String removeOccurrences1(String s, String part) {
        while (true) {
            int index = s.indexOf(part);
            if (index == -1) {
                break;
            }
            s = s.substring(0, index) + s.substring(index + part.length(), s.length());
        }
        return s;
    }

    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int strLength = s.length();
        int partLength = part.length();

        for (int index = 0; index < strLength; index++) {
            st.push(s.charAt(index));
            
            // check for the char in stack
            if (st.size() >= partLength && checkStack(st, part, partLength)) {
                // pop up
                for (int j = 0; j < partLength; j++) {
                    st.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString();
    }

    private boolean checkStack(Stack<Character> st, String part, int partLength) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(st);

        for (int index = partLength - 1; index >= 0; index--) {
            if (temp.isEmpty() || temp.peek() != part.charAt(index)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}
/*
da abc baabcbc 

daba abc bc

dab abc

dab

*/