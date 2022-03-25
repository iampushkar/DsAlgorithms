class Solution {
    
    public int largestRectangleArea(int[] A) {
        int N = A.length;
        int[] p1 = getFirstSmallerIndexOnLeft(A);
        int[] p2 = getFirstSmallerIndexOnRight(A);
        int area = 0;

        for(int i=0; i<N; i++) {
            int width = p2[i] - p1[i] - 1;
            int height = A[i];
            area = Math.max(area, width * height);
        }
        return area;
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
}