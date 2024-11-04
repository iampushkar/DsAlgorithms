class Solution {
    public boolean isCircularSentence(String sentence) {
        int N = sentence.length();
        
        for (int i = 0; i < N; i++) {
            if (sentence.charAt(i) == ' ' && (sentence.charAt(i-1) != sentence.charAt(i+1))) {
                return false;
            }
        }
        return sentence.charAt(0) == sentence.charAt(N-1);
    }
}