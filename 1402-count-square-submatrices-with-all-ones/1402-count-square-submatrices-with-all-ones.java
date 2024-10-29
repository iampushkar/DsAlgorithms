class Solution {
    public int countSquares(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int[][] dp = new int[ROWS][COLS];
        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                Arrays.fill(dp[i], -1);
            }
        }

        int count = 0;
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                count += dfs(r, c, dp, matrix, ROWS, COLS);
            }
        }
        return count;
    }

    private int dfs(int r, int c, int[][] dp, int[][] matrix, int ROWS, int COLS) {
        if (r == ROWS || c == COLS || matrix[r][c] != 1) {
            return 0;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 1 + Math.min(
            dfs(r+1, c, dp, matrix, ROWS, COLS),
            Math.min(
                dfs(r, c+1, dp, matrix, ROWS, COLS),
                dfs(r+1, c+1, dp, matrix, ROWS, COLS)
            )
        );

        return dp[r][c];
    }
}

// lc 221