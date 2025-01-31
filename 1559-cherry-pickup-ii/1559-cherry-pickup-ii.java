class Solution {
    public int cherryPickup(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][][] dp = new int[ROWS][COLS][COLS];

        for (int i=0; i<ROWS; i++) {
            for (int j1=0; j1<COLS; j1++) {
                for (int j2=0; j2<COLS; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }

        return memo(0, 0, COLS-1, grid, ROWS, COLS, dp);
    }

    private int memo(int i, int j1, int j2, int[][] mat, int N, int M, int[][][] dp) {
        // base case
        if (j1 < 0 || j1 > M-1 || j2 < 0 || j2 > M-1) {
            return Integer.MIN_VALUE;
        }
        if (i == N - 1) {
            // cases 
            if (j1 == j2) {
                return mat[i][j1];
            } else {
                return mat[i][j1] + mat[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        // compute 9 scenarios
        int maxi = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                // cases
                int value;
                if (j1 == j2) {
                    value = mat[i][j1] + memo(i+1, j1+dj1, j2+dj2, mat, N, M, dp);
                } else {
                    value = mat[i][j1] + mat[i][j2] + memo(i+1, j1+dj1, j2+dj2, mat, N, M, dp);
                }

                maxi = Math.max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}