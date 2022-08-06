class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        
        for(int i=1; i<intervals.length; i++) {
            int[] prev = stack.peek();
            int[] curr = intervals[i];
            
            if(prev[1] >= curr[0]) { //merge and push to stack
                int start = Math.min(prev[0], curr[0]);
                int end = Math.max(prev[1], curr[1]);
                stack.pop();
                stack.push(new int[]{start, end});
            } else {
                stack.push(curr);
            }
        }
        
        int N = stack.size();
        int[][] ans = new int[N][2];
        int k = N-1;
        while(!stack.isEmpty()) {
            ans[k] = stack.pop();
            k--;
        }
        
        return ans;
    }
}