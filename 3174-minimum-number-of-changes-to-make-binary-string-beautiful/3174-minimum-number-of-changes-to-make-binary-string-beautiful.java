class Solution {
    public int minChanges(String s) {
        int N = s.length();
        int change = 0;
        for (int i=0; i<N; i=i+2) {
            if (s.charAt(i) != s.charAt(i+1)) {
                change++;
            }
        }
        return change;
    }
}