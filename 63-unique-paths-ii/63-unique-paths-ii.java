class Solution {
    
    public int uniquePathsWithObstacles(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] dp = new int[row][col];

        if(A[0][0] == 1) return 0;

        dp[0][0] = 1;
        for(int i=1; i<row; i++) {
            if(A[i][0] == 0 && dp[i-1][0] == 1) {
                dp[i][0] = 1;
            }
        }
        for(int j=1; j<col; j++) {
            if(A[0][j] == 0 && dp[0][j-1] == 1) {
                dp[0][j] = 1;
            }
        }

        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                if(A[i][j] == 0) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        printMatrix(dp);

        return dp[row-1][col-1];
    }

    static void printMatrix(int[][] dp) {
        int row = dp.length;
        int col = dp[0].length;

         for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                System.out.print(dp[i][j] + " , ");
            }
            System.out.println();
        }
    }
}