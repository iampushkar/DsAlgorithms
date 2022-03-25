class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] A = new int[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                char c = (matrix[i][j]);
                A[i][j] = Character.getNumericValue(c);
            }
        }
        
        return solve(A);
    }
    
    public int solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] prefix = buildPrefixColumnMatrix(A, rows, cols);
        int[] maxArea = maxRectangleAreaArray(prefix);

        int ansArea = Integer.MIN_VALUE;
        for(int i=0; i<maxArea.length; i++) {
            ansArea = Math.max(ansArea, maxArea[i]);
        }

        return ansArea;
    }

    private static int[] maxRectangleAreaArray(int[][] prefix) {
        int rows = prefix.length;
        int[] maxArea = new int[rows];
        for(int i=0; i<rows; i++) {
            int[] arr = prefix[i];
            maxArea[i] = maxAreaInHistogram(arr);
        }
        return maxArea;
    }

    private static int maxAreaInHistogram(int[] A) {
        int[] p1 = getFirstSmallerIndexOnLeft(A);
        int[] p2 = getFirstSmallerIndexOnRight(A);
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<A.length; i++) {
            int width = p2[i] - p1[i] - 1;
            int height = A[i];
            ans = Math.max(ans, width * height);
        }
        return ans;
    }

    private static int[] getFirstSmallerIndexOnLeft(int[] A) {
        int N = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[N];
        Arrays.fill(ans, -1);

        for(int i=0; i<N; i++) {
            while(!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] getFirstSmallerIndexOnRight(int[] A) {
        int N = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[N];
        Arrays.fill(ans, N);

        for(int i=N-1; i>=0; i--) {
            while(!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[][] buildPrefixColumnMatrix(int[][] A, int rows, int cols) {
        int[][] prefix = new int[rows][cols];

        //initializing the first row
        for(int j=0; j<cols; j++) {
            prefix[0][j] = A[0][j];
        }

        //iterating and preparing prefix
        for(int j=0; j<cols; j++) {
            for(int i=1; i<rows; i++) {
                int val = A[i][j];
                if(val == 0) {
                    prefix[i][j] = 0; //edge case 
                } else {
                    prefix[i][j] = prefix[i-1][j] + A[i][j];
                }
            }
        }
        return prefix;
    }
}