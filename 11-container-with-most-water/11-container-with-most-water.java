class Solution {
    public int maxArea(int[] height) {
       int start = 0, end = height.length-1;
        int ans = Integer.MIN_VALUE;
            
        while(start <= end) {
            int leftVal = height[start];
            int rightVal = height[end];
            int minHeight = Math.min(leftVal, rightVal);
            int width = end - start;
            int area = minHeight * width;
            ans = Math.max(ans, area);
            
            if(leftVal < rightVal) {
                start++;
            } else {
                end--;
            }
            
        }
        return ans;
    }
}
