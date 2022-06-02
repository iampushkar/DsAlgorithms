class Solution {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] ans = new int[col][row];
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                // int temp = matrix[i][j];
                // matrix[i][j] = matrix[j][i];
                // matrix[j][i] = temp;
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
    
}
/*
1 2 3 
4 5 6 

1 4
2 5
3 6

1 4 3
2 5 6*/