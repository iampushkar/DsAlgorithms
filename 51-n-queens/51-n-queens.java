class Solution {
    
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] chess = new int[n][n];

        printNQueens(chess, 0);
        return ans;
    }
    
    private void printNQueens(int[][] chess, int row) {
        if(row == chess.length) {
            //iterate and print the matrix
            List<String> currList = new ArrayList<>();
            for(int i=0; i<chess.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<chess.length; j++) {
                    int val = chess[i][j];
                    if(val == 0) {
                        sb.append(".");
                    } else if(val == 1) {
                        sb.append("Q");
                    }
                }
                currList.add(sb.toString());
            }
            ans.add(currList);
            return;
        }

        for(int col=0; col<chess.length; col++) {
            if(checkIfQueenCanBePlaced(chess, row, col) == true) {
                chess[row][col] = 1; //place the queen
                printNQueens(chess, row+1);
                chess[row][col] = 0; //remove the queen
            }
        }
    }

    private boolean checkIfQueenCanBePlaced(int[][] chess, int row, int col) {
        //iterating vertically upward on same column
        for(int i=row-1, j=col; i>=0; i--) {
            if(chess[i][j] == 1) {
                return false;
            }
        }

        //iterating left diagonal upward
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(chess[i][j] == 1) {
                return false;
            }
        }

        //iterating right diagonal upward
        for(int i=row-1, j=col+1; i>=0 && j<chess.length; i--, j++) {
            if(chess[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
    
}