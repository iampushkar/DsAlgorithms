class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            int charIdx = c - 'a';
            freq[charIdx]++;
        }
        

        int length = 0;
        for (int i = 0; i<26; i++) {
            System.out.println(i + " :: " + freq[i]);
            if (freq[i] == 0) continue;
            if (freq[i] % 2 == 0) {
                length += 2;
            } else if(freq[i] % 2 != 0) {
                length += 1;
            }
        }
        return length;
    }
}