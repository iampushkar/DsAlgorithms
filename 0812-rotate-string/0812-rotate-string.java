class Solution {
    public boolean rotateString(String s, String goal) {
       int N = s.length();
       StringBuilder sb = new StringBuilder(s);

       for(int i=0; i<N; i++) {
        if (sb.toString().equals(goal)) {
            return true;
        }
        char first = sb.charAt(0);
        sb = sb.deleteCharAt(0).append(first);
       }

        return false;
    }
}
/*
a b c d e -----> c d e a b
b c d e a
c d e a b

a b c d e  ----> a b c e d
b c d e a
c d e a b
d e a b c
e a b c d
a b c d e


*/