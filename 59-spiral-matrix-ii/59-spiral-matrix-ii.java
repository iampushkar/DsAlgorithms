class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int row=0, col=0;
        int val = 1;
        while(n > 1) {
            for(int l=1; l<n; l++) {
                mat[row][col] = val;
                val++;
                col++;
            }
            for(int l=1; l<n; l++) {
                mat[row][col] = val;
                val++;
                row++;
            }
            for(int l=1; l<n; l++) {
                mat[row][col] = val;
                val++;
                col--;
            }
            for(int l=1; l<n; l++) {
                mat[row][col] = val;
                val++;
                row--;
            }
            
            n = n - 2;
            row++;
            col++;
        }
        
        if(n == 1) {
            mat[row][col] = val;
        }
        return mat;
    }
}