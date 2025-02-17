class Solution {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            int idx = c - 'A';
            count[idx]++;
        }

        return solve(count);
    }

    private int solve(int[] count) {
        int total = 0;

        for (int i=0; i<26; i++) {
            if (count[i] == 0) continue;

            total++;
            count[i]--;

            total += solve(count);

            count[i]++;
        }

        return total;
    }
}