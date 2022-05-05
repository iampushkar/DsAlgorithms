class Solution {

    public int minPathSum(int[][] A) {
    
        int row = A.length;
        int col = A[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = A[0][0];
        for(int i=1; i<row; i++){
            dp[i][0] = dp[i-1][0] + A[i][0];
        }
        for(int i=1; i<col; i++){
            dp[0][i] = dp[0][i-1] + A[0][i];
        }

        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                dp[i][j] = A[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }
        
        //printMatrix(dp);

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