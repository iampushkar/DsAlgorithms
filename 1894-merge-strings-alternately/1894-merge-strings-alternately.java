class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int first = 0;
        int second = 0;
        int N1 = word1.length();
        int N2 = word2.length();

        while (first < N1 && second < N2) {
            res.append(word1.charAt(first++));
            res.append(word2.charAt(second++));
        }

        while (first < N1) {
            res.append(word1.charAt(first++));
        }

        while (second < N2) {
            res.append(word2.charAt(second++));
        }
        
        return res.toString();
    }
}