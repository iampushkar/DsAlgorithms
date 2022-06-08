class NumMatrix {
    
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        prefix = prefixSum(matrix);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        //int[][] prefix = prefixSum(mat);
         
        int sum = prefix[row2][col2];
        
        if(col1 >= 1) {
            sum -= prefix[row2][col1-1];
        }
        if(row1 >= 1) {
            sum -= prefix[row1-1][col2];
        }
        if(row1 >= 1 && col1 >= 1) {
            sum += prefix[row1-1][col1-1];
        }
        
        return sum;
    }
    
    private int[][] prefixSum(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
            
        //row wise
        for(int i=1; i<row; i++) {
            for(int j=0; j<col; j++) {
                mat[i][j] += mat[i-1][j];
            }
        }
        
        //col wise
        for(int i=0; i<row; i++) {
            for(int j=1; j<col; j++) {
                mat[i][j] += mat[i][j-1];
            }
        }
        
        return mat;
    }
    
    private void print(int[][] mat) {
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */