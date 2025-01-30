class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // int ROWS = matrix.length;
        // int COLS = matrix[0].length;
        // int[][] dp = new int[ROWS][COLS];

        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }

        // int res = Integer.MAX_VALUE;
        // for (int c = 0; c < COLS; c++) {
        // int pathSum = solve(ROWS - 1, c, matrix, dp);
        // res = Math.min(res, pathSum);
        // }

        // return res;
        return tabulation(matrix);
    }

    private int solve(int row, int col, int[][] matrix, int[][] dp) {
        // base case
        if (row == 0)
            return matrix[0][col];
        if (col < 0 || col >= matrix[0].length)
            return (int) Math.pow(10, 9);

        if (dp[row][col] != -1)
            return dp[row][col];

        int up = solve(row - 1, col, matrix, dp);
        int leftUpDiagonal = (col > 0) ? solve(row - 1, col - 1, matrix, dp) : (int) Math.pow(10, 9);
        int rightUpDiagonal = (col < matrix[0].length - 1) ? solve(row - 1, col + 1, matrix, dp)
                : (int) Math.pow(10, 9);

        int min = matrix[row][col] + Math.min(up, Math.min(leftUpDiagonal, rightUpDiagonal));
        return dp[row][col] = min;
    }

    public int tabulation(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++)
            dp[0][j] = matrix[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int leftUpDiagonal = 0, rightUpDiagonal = 0;

                int up = dp[i - 1][j];

                leftUpDiagonal = (j > 0) ?  dp[i - 1][j - 1] : (int) Math.pow(10, 9);

                rightUpDiagonal = (j < n - 1) ? dp[i - 1][j + 1] : (int) Math.pow(10, 9);

                // if (j > 0)
                //     leftUpDiagonal = matrix[i][j] + dp[i - 1][j - 1];
                // else
                //     leftUpDiagonal = (int) 1e9;

                // if (j + 1 < n)
                //     diag2 = matrix[i][j] + dp[i - 1][j + 1];
                // else
                //     diag2 = (int) 1e9;

                int minPath = matrix[i][j] + Math.min(up, Math.min(leftUpDiagonal, rightUpDiagonal));
                dp[i][j] = minPath;
            }
        }

        for (int j = 0; j < n; j++)
            ans = Math.min(ans, dp[n - 1][j]);

        return ans;
    }
}
