class Solution {
    public int minDistance(String word1, String word2) {
        int N = word1.length();
        int M = word2.length();

        int[][] dp = new int[N][M];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return memo(N-1, M-1, word1, word2, dp);
    }

    private int memo(int i, int j, String word1, String word2, int[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = memo(i-1, j-1, word1, word2, dp);
        }

        return dp[i][j] = 1 + Math.min(
            memo(i-1, j, word1, word2, dp),
            Math.min(
                memo(i, j-1, word1, word2, dp), memo(i-1, j-1, word1, word2, dp)
            )
        );

    }
}