class Solution {
    public int trap(int[] height) {
        int N = height.length;
        
        //left max 
        int[] leftMax = new int[N];
        leftMax[0] = height[0];
        for(int i=1; i<N; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        
        //right max
        int[] rightMax = new int[N];
        rightMax[N-1] = height[N-1];
        for(int i=N-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        
        int res = 0;
        //rainwater trapping
        for(int i=1; i<N-1; i++) {
            int left = leftMax[i-1];
            int right = rightMax[i+1];
            int minHeight = Math.min(left, right);
            int waterTrap = Math.max(minHeight - height[i], 0);
            res += waterTrap;
        }
        
        return res;
    }
}